function dateAreaChart() {
    var w = 500;
    var h = 500;
    var x = d3.time.scale().range([0, w]);
    var y = d3.scale.linear().range([h, 0]);

    var xAxis = d3.svg.axis().orient("bottom").scale(x);
    var yAxis = d3.svg.axis().orient("left").scale(y);


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

    var svg = d3.select("#kotlinCommitsVsAll").append("svg")
        .attr("width", w)
        .attr("height", h)
        .attr("viewBox", "0 0 " + h + " " + w)
        .attr("preserveAspectRatio", "xMidYMid meet");

    d3.json("/api/kotlinCommitsVsAll", function (error, data) {

        data.forEach(function (d) {
            d.date = Date.parse(d.date);
        });

        x.domain(d3.extent(data, function (d) {
            return d.date;
        }));
        y.domain([0, d3.max(data, function (d) {
            return d.all;
        })]);

        svg.append("path")
            .datum(data)
            .attr("class", "area")
            .attr("d", area1);


        svg.append("path")
            .datum(data)
            .attr("class", "area1")
            .attr("d", area2);

        svg.append("g")
            .attr("class", "x axis")
            .attr("transform", "translate(0," + h + ")")
            .call(xAxis);

        svg.append("g")
            .attr("class", "y axis")
            .call(yAxis)
    })
}