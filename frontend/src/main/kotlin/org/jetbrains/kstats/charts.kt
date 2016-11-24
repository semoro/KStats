package org.jetbrains.kstats

// TODO report issue about problems with autoimport
import d3.d3 as _d3
import d3.d3.scale.Linear
import d3.d3.Selection

private class GradientPoint(val offset: String, val color: String)

private class LegendEntry(val text: String, val color: String)

@native
private interface QueryPerDayResult {
    var date: Any
    val all: Int
    val kotlin: Int
}

private fun <T> dynamic.unsafeCast(): T = this

object Charts {
    fun d3linearGradient(svg: Selection<Any>, h: Int, y: Linear<Number, Number>, id: String, colorA: String, colorB: String) {
        svg.append("linearGradient")
                .attr("id", id)
                .attr("gradientUnits", "userSpaceOnUse")
                .attr("x1", 0).attr("y1", y(0))
                .attr("x2", 0).attr("y2", y(h))
                .selectAll("stop")
                .data(arrayOf(
                        GradientPoint(offset = "0%", color = colorA),
                        GradientPoint(offset = "100%", color = colorB)
                ))
        .enter().append("stop")
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

    fun mountDateAreaChart(dataUrl: String, attachRootSelector: String, legendLabels: Array<String>): Unit {
        val fullW = 500
        val fullH = 300
        val w = fullW - Margin.left - Margin.right
        val h = fullH - Margin.top - Margin.bottom

        val x = _d3.time.scale().range(arrayOf(0, w))
        val y = _d3.scale.linear().range(arrayOf(h, 0))
    
        val xAxis = _d3.svg.axis().orient("bottom").scale(x)
    
        val yAxis = _d3.svg.axis().orient("left").scale(y).tickSize(-w)
    
    
        val area1 = _d3.svg.area<QueryPerDayResult>()
                .x({ data, _ ->
                    x(data.date.unsafeCast())
                })
                .y0(h)
                .y1({ data, _ ->
                    y(data.all)
                })
    
        val area2 = _d3.svg.area<QueryPerDayResult>()
                .x({ data, _ ->
                    x(data.date.unsafeCast())
                })
                .y0(h)
                .y1({ data, _ ->
                    y(data.kotlin)
                })
    
        val svg = _d3.select(attachRootSelector).append("svg")
                .attr("width", "100%")
                //.attr("height", h)
                .attr("viewBox", "0 0 " + (fullW + Margin.right) + " " + fullH)
                .attr("preserveAspectRatio", "xMidYMid meet")
                .append("g")
                .attr("transform", "translate(" + Margin.left + "," + Margin.top + ")")
    
        d3linearGradient(svg, 1, y, "all-gradient", "#00c8ff", "#8767ff")
        d3linearGradient(svg, 1, y, "kotlin-gradient", "#c757bc", "#f88909")
    
        _d3.json(dataUrl, { _, data_ ->
            val data = data_.unsafeCast<Array<QueryPerDayResult>>()

            data.forEach({ d ->
                d.date = js("Date").parse(d.date)
                Unit
            })
    
            x.domain(_d3.extent(data, { d, _ ->
                d.date.unsafeCast()
            })).nice()
            y.domain(arrayOf(0, _d3.max(data, { d, _ ->
                d.all
            })))
    
    
            svg.append("path")
                    .datum(data)
                    .attr("class", "all")
                    .attr("d", area1)
                    .attr("style", "fill: url(#all-gradient);")
    
    
            svg.append("path")
                    .datum(data)
                    .attr("class", "kotlin")
                    .attr("d", area2)
                    .attr("style", "fill: url(#kotlin-gradient);")
    
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

            val legend = svg.selectAll(".legend")
                    .data(legendLabels.zip(arrayOf("#8566ff", "#f58612")).map { (text, color) -> LegendEntry(text, color) }.toTypedArray())
            .enter()
                    .append("g")
                    .attr("class", "legend")
                    .attr("transform", { _, i, _ ->
                        "translate(" + i * legendSpacing + ", -18)"
                    });
    
            legend.append("rect")
                    .attr("width", legendRectSize)
                    .attr("height", legendRectSize)
                    .style("fill", { d, _, _ ->
                        d.color
                    })
            legend.append("text")
                    .attr("x", legendRectSize * 2)
                    .attr("y", legendRectSize)
                    .text({ d, _, _ ->
                        d.text
                    })
        })
    }
}
