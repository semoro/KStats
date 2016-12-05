package org.jetbrains.kstats

import bindings.d3
import bindings.d3.Selection
import kotlin.properties.Delegates.notNull


private class GradientPoint(val offset: String, val color: String)

private class LegendEntry(val text: String, val gradient: String)

@native
private interface QueryPerDayResult {
    var date: Any
    val all: Int
    val kotlin: Int
}

@Suppress("UnsafeCastFromDynamic")
private fun <T> dynamic.unsafeCast(): T = this

object Charts {
    fun d3linearGradient(svg: Selection<Any>, h: Number, id: String, colorA: String, colorB: String) {
        svg.append("linearGradient")
                .attr("id", id)
                .attr("gradientUnits", "userSpaceOnUse")
                .attr("x1", 0).attr("y1", h)
                .attr("x2", 0).attr("y2", 0)
                .selectAll("stop")
                .data(arrayOf(
                        GradientPoint(offset = "0%", color = colorA),
                        GradientPoint(offset = "100%", color = colorB)
                ))
                .enter()
                .append("stop")
                .attr("offset", { d, _, _ ->
                    d.offset
                })
                .attr("stop-color", { d, _, _ ->
                    d.color
                })
    }

    private object Margin {
        val top = 20
        val right = 20
        val bottom = 30
        val left = 50
    }

    private fun shadow(defs: d3.Selection<Any>, id: String, height: String, deviation: Double, dy: Double) {
        val shadowFilter = defs.append("filter")
                .attr("id", id)
                .attr("height", height)

        shadowFilter.append("feGaussianBlur")
                .attr("in", "SourceAlpha")
                .attr("stdDeviation", deviation)
                .attr("result", "blur")

        shadowFilter.append("feFlood")
                .attr("flood-color", "rgba(0,0,0,0.7)")
                .attr("result", "offsetColor")

        shadowFilter.append("feOffset")
                .attr("in", "blur")
                .attr("dy", dy)
                .attr("result", "offsetBlur")

        shadowFilter.append("feComposite")
                .attr("in", "offsetColor")
                .attr("in2", "offsetBlur")
                .attr("operator", "in")
                .attr("result", "offsetBlur")

        val feMerge = shadowFilter.append("feMerge")

        feMerge.append("feMergeNode")
                .attr("in", "offsetBlur")
        feMerge.append("feMergeNode")
                .attr("in", "SourceGraphic")
    }

    private data class ChartPoint(val original: QueryPerDayResult, val x: Double, val y1: Double, val y2: Double)

    fun mountDateAreaChart(dataUrl: String, attachRootSelector: String, legendLabels: Array<String>): Unit {
        val fullW = 500
        val fullH = 300
        val w = fullW - Margin.left - Margin.right
        val h = fullH - Margin.top - Margin.bottom

        val x = d3.time.scale().range(arrayOf(0, w))
        val y = d3.scale.linear().range(arrayOf(h, 0))

        val xAxis = d3.svg.axis().orient("bottom").scale(x)

        val yAxis = d3.svg.axis().orient("left").scale(y).tickSize(-w)


        val area1 = d3.svg.area<QueryPerDayResult>()
                .x({ data, _ ->
                    x(data.date.unsafeCast())
                })
                .y0(h)
                .y1({ data, _ ->
                    y(data.all)
                })

        val area2 = d3.svg.area<QueryPerDayResult>()
                .x({ data, _ ->
                    x(data.date.unsafeCast())
                })
                .y0(h)
                .y1({ data, _ ->
                    y(data.kotlin)
                })

        val svg = d3.select(attachRootSelector).append("svg")
                .attr("width", "100%")
                .attr("viewBox", "0 0 " + (fullW + Margin.right) + " " + fullH)
                .attr("preserveAspectRatio", "xMidYMid meet")
                .append("g")
                .attr("transform", "translate(" + Margin.left + "," + Margin.top + ")")

        val defs = svg.append("defs")


        d3.json(dataUrl, { _, data_ ->
            val data = data_.unsafeCast<Array<QueryPerDayResult>>()

            data.forEach({ d ->
                d.date = js("Date").parse(d.date).unsafeCast()
                Unit
            })

            x.domain(d3.extent(data, { d, _ ->
                d.date.unsafeCast()
            })).nice()
            y.domain(arrayOf(0, d3.max(data, { d, _ ->
                d.all
            })))

            d3linearGradient(svg, y(1), "all-gradient", "#00c8ff", "#8767ff")
            d3linearGradient(svg, y(1), "kotlin-gradient", "#c757bc", "#f88909")

            shadow(defs, "area-shadow", "150%", 0.55, -0.2)

            svg.append("path")
                    .datum(data)
                    .attr("class", "all")
                    .attr("d", area1)
                    .attr("style", "fill: url(#all-gradient);" +
                            "filter: url(#area-shadow)")

            svg.append("path")
                    .datum(data)
                    .attr("class", "kotlin")
                    .attr("d", area2)
                    .attr("style", "fill: url(#kotlin-gradient);" +
                            "filter: url(#area-shadow)" +
                            "")

            xAxis.ticks(7)
    
            svg.append("g")
                    .attr("class", "x axis")
                    .attr("transform", "translate(0, $h)")
                    .call(xAxis)

            svg.append("g")
                    .attr("class", "y axis")
                    .call(yAxis)

            val legendRectSize = 10
            val legendSpacing = 200

            d3linearGradient(svg, legendRectSize, "all-legend-gradient", "#00c8ff", "#8767ff")
            d3linearGradient(svg, legendRectSize, "kotlin-legend-gradient", "#c757bc", "#f88909")

            val legend = svg.selectAll(".legend")
                    .data(legendLabels.zip(arrayOf("#all-legend-gradient", "#kotlin-legend-gradient"))
                            .map { (text, color) -> LegendEntry(text, color) }.toTypedArray())
                    .enter()
                    .append("g")
                    .attr("class", "legend")
                    .attr("transform", { _, i, _ ->
                        "translate(${i * legendSpacing}, -18)"
                    })

            legend.append("rect")
                    .attr("width", legendRectSize)
                    .attr("height", legendRectSize)
                    .style("fill", { d, _, _ ->
                        "url(${d.gradient})"
                    })

            legend.append("text")
                    .attr("x", legendRectSize * 2)
                    .attr("y", legendRectSize)
                    .text({ d, _, _ ->
                        d.text
                    })

            shadow(defs, "tooltip-shadow", "200%", 0.6, 0.48)

            val tooltip = svg.append("g")
                    .attr("class", "tooltip x")
                    .style("display", "none")

            tooltip.append("line")
                    .attr("x2", 0)
                    .attr("y2", h)

            val tooltipPointAll = tooltip.append("circle")
                    .attr("id", "all")
                    .attr("r", 3)
            val tooltipPointKotlin = tooltip.append("circle")
                    .attr("id", "kotlin")
                    .attr("r", 3)

            val tooltipY = tooltip.append("g")
                    .attr("class", "tooltip y")

            val tooltipBoxGroup = tooltipY.append("g")
                    .attr("class", "box")
                    .attr("transform", "translate(-28,0)")

            val tooltipHeight = 45.0
            val tooltipMargin = 10.0

            tooltipBoxGroup
                    .append("rect")
                    .attr("class", "box")
                    .attr("style", "filter: url(#tooltip-shadow);")
                    .attr("x", -1)
                    .attr("y", -1)
                    .attr("width", 58)
                    .attr("height", tooltipHeight)


            val tooltipEntries = tooltipBoxGroup.selectAll(".tooltip.entry")
                    .data(arrayOf("#all-legend-gradient", "#kotlin-legend-gradient", ""))
                    .enter()
                    .append("g")
                    .attr("class", "tooltip entry")
                    .attr("transform", { _, i, _ ->
                        "translate(0, ${i * 15})"
                    })


            tooltipEntries.append("text")
                    .attr("x", legendRectSize * 2)
                    .attr("y", legendRectSize)

            tooltipEntries.append("rect")
                    .attr("width", legendRectSize)
                    .attr("height", legendRectSize)
                    .style("fill", { d, _, _ ->
                        "url($d)"
                    })


            svg.append("rect")
                    .datum(data)
                    .attr("class", "tooltip-zone")
                    .attr("width", w)
                    .attr("height", h)
                    .attr("style", "fill: none;")
                    .attr("pointer-events", "all")
                    .on("mouseover", { _, _, _ ->
                        tooltip.style("display", "")
                    })
                    .on("mouseout", { _, _, _ ->
                        tooltip.style("display", "none")
                    })
                    .on("mousemove", { d, _, _ ->
                        val (xPos) = d3.mouse(this)
                        val point = d.map {
                            ChartPoint(it,
                                    x(it.date.unsafeCast()).toDouble(),
                                    y(it.all).toDouble(),
                                    y(it.kotlin).toDouble())
                        }.minBy { Math.abs(it.x - xPos.toDouble()) }!!

                        tooltip.attr("transform", "translate(${point.x},0)")

                        tooltipPointAll.attr("cy", point.y1)
                        tooltipPointKotlin.attr("cy", point.y2)

                        val top = 0.0 to point.y1
                        val middle = point.y1 to point.y2
                        val bottom = point.y2 to h.toDouble()

                        val placeLocation = listOf(top, middle, bottom)
                                .maxBy { Math.abs(it.second - it.first) }

                        val yPlace = when (placeLocation) {
                            top -> placeLocation.second - tooltipHeight - tooltipMargin
                            middle -> placeLocation.first + tooltipMargin
                            bottom -> tooltipMargin
                            else -> 0.0
                        }

                        tooltipY.attr("transform", "translate(0, $yPlace)")
                        val percent = Math.round(point.original.kotlin.toDouble() / point.original.all.toDouble() * 100.0)
                        tooltipBoxGroup.selectAll("text")
                                .data(arrayOf(point.original.all,
                                        point.original.kotlin,
                                        "$percent%"))
                                .text { text, _, _ -> text }

                    })
        })
    }
}
