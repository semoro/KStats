var Charts = {};


Charts.d3linearGradient = function (svg, h, y, id, colorA, colorB) {
    svg.append("linearGradient")
        .attr("id", id)
        .attr("gradientUnits", "userSpaceOnUse")
        .attr("x1", 0).attr("y1", y(0))
        .attr("x2", 0).attr("y2", y(h))
        .selectAll("stop")
        .data([
            {offset: "0%", color: colorA},
            {offset: "100%", color: colorB}
        ])
        .enter().append("stop")
        .attr("offset", function (d) {
            return d.offset;
        })
        .attr("stop-color", function (d) {
            return d.color;
        });
};

Charts.mountDateAreaChart = function (dataUrl, attachRootSelector) {
    var margin = {top: 20, right: 20, bottom: 30, left: 50};
    var fullW = 500;
    var fullH = 300;
    var w = fullW - margin.left - margin.right;
    var h = fullH - margin.top - margin.bottom;

    var x = d3.time.scale().range([0, w]);
    var y = d3.scale.linear().range([h, 0]);

    var xAxis = d3.svg.axis().orient("bottom").scale(x);

    var yAxis = d3.svg.axis().orient("left").scale(y).tickSize(-w);


    var area1 = d3.svg.area()
        .x(function (data) {
            return x(data.date)
        })
        .y0(h)
        .y1(function (data) {
            return y(data.all)
        });

    var area2 = d3.svg.area()
        .x(function (data) {
            return x(data.date)
        })
        .y0(h)
        .y1(function (data) {
            return y(data.kotlin)
        });

    var svg = d3.select(attachRootSelector).append("svg")
        .attr("width", "100%")
        //.attr("height", h)
        .attr("viewBox", "0 0 " + (fullW + margin.right) + " " + fullH)
        .attr("preserveAspectRatio", "xMidYMid meet")
        .append("g")
        .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    Charts.d3linearGradient(svg, 1, y, "all-gradient", "#00c8ff", "#8767ff");
    Charts.d3linearGradient(svg, 1, y, "kotlin-gradient", "#c757bc", "#f88909");

    d3.json(dataUrl, function (error, data) {

        data.forEach(function (d) {
            d.date = Date.parse(d.date);
        });

        x.domain(d3.extent(data, function (d) {
            return d.date;
        })).nice();
        y.domain([0, d3.max(data, function (d) {
            return d.all;
        })]);


        svg.append("path")
            .datum(data)
            .attr("class", "all")
            .attr("d", area1)
            .attr("style", "fill: url(#all-gradient);");


        svg.append("path")
            .datum(data)
            .attr("class", "kotlin")
            .attr("d", area2)
            .attr("style", "fill: url(#kotlin-gradient);");

        xAxis.ticks(7);

        svg.append("g")
            .attr("class", "x axis")
            .attr("transform", "translate(0," + h + ")")
            .call(xAxis);

        svg.append("g")
            .attr("class", "y axis")
            .call(yAxis);

        var legendRectSize = 10;
        var legendSpacing = 200;


        var legend = svg.selectAll('.legend')
            .data([{text: "All commits", color: "#8566ff"}, {text: "Kotlin commits", color: "#f58612"}])
            .enter()
            .append('g')
            .attr('class', 'legend')
            .attr('transform', function (d, i) {
                return 'translate(' + i * legendSpacing + ', -18)';
            });

        legend.append('rect')
            .attr('width', legendRectSize)
            .attr('height', legendRectSize)
            .style('fill', function (d) {
                return d.color
            });
        legend.append('text')
            .attr('x', legendRectSize * 2)
            .attr('y', legendRectSize)
            .text(function (d) {
                return d.text;
            });
    })
}