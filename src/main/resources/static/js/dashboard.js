jQuery(document).ready(function () {

    "use strict";

    function showTooltip(x, y, contents) {
        jQuery('<div id="tooltip" class="tooltipflot">' + contents + '</div>').css({
            position: 'absolute',
            display: 'none',
            top: y + 5,
            left: x + 5
        }).appendTo("body").fadeIn(200);
    }

    var uploads = [[1, 6478], [2, 6461], [3, 6450], [4,6462 ], [5, 6339], [6, 6432]];
    var average = [[1, 6364], [2, 6360], [3, 6364], [4, 6374], [5, 6332], [6, 6387]];
    var downloads = [[1, 6250], [2, 6259], [3, 6278], [4, 6285], [5, 6324], [6, 6341]];

    var plot = jQuery.plot(jQuery("#basicflot"),
        [{
            data: uploads,
            label: "最高气压",
            color: "#e36f30"
        },
            {
                data:average,
                label:"平均气压",
                color: "#4c982c"
            },
            {
                data: downloads,
                label: "最低气压",
                color: "#428BCA"
            }
        ],
        {
            series: {
                lines: {
                    show: false
                },
                splines: {
                    show: true,
                    tension: 0.5,
                    lineWidth: 1,
                    fill: 0.45
                },
                shadowSize: 0
            },
            points: {
                show: true
            },
            legend: {
                position: 'nw'
            },
            grid: {
                hoverable: true,
                clickable: true,
                borderColor: '#ddd',
                borderWidth: 1,
                labelMargin: 10,
                backgroundColor: '#fff'
            },
            yaxis: {
                min: 6150,
                max: 6500,
                color: '#eee'
            },
            xaxis: {
                color: '#eee'
            }
        });

    var previousPoint = null;
    jQuery("#basicflot").bind("plothover", function (event, pos, item) {
        jQuery("#x").text(pos.x.toFixed(1));
        jQuery("#y").text(pos.y.toFixed(1));

        if (item) {
            if (previousPoint != item.dataIndex) {
                previousPoint = item.dataIndex;

                jQuery("#tooltip").remove();
                var x = item.datapoint[0].toFixed(2),
                    y = item.datapoint[1].toFixed(2);

                showTooltip(item.pageX, item.pageY,
                    item.series.label + " of " + x + " = " + y);
            }

        } else {
            jQuery("#tooltip").remove();
            previousPoint = null;
        }

    });

    jQuery("#basicflot").bind("plotclick", function (event, pos, item) {
        if (item) {
            plot.highlight(item.series, item.datapoint);
        }
    });

    // Donut Chart
    var m1 = new Morris.Donut({
        element: 'donut-chart2',
        data: [
            {label: "Chrome", value: 30},
            {label: "Firefox", value: 20},
            {label: "Opera", value: 20},
            {label: "Safari", value: 20},
            {label: "Internet Explorer", value: 10}
        ],
        colors: ['#D9534F', '#1CAF9A', '#428BCA', '#5BC0DE', '#428BCA']
    });


    var m2 = new Morris.Line({
        // ID of the element in which to draw the chart.
        element: 'line-chart',
        // Chart data records -- each entry in this array corresponds to a point on
        // the chart.
        data: [
            {y: '2006', a: 50, b: 0},
            {y: '2007', a: 60, b: 25},
            {y: '2008', a: 45, b: 30},
            {y: '2009', a: 40, b: 20},
            {y: '2010', a: 50, b: 35},
            {y: '2011', a: 60, b: 50},
            {y: '2012', a: 65, b: 55}
        ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        gridTextColor: 'rgba(255,255,255,0.5)',
        lineColors: ['#fff', '#fdd2a4'],
        lineWidth: '2px',
        hideHover: 'always',
        smooth: false,
        grid: false
    });

    // Trigger Resize in Morris Chart
    var delay = (function () {
        var timer = 0;
        return function (callback, ms) {
            clearTimeout(timer);
            timer = setTimeout(callback, ms);
        };
    })();

    jQuery(window).resize(function () {
        delay(function () {
            m1.redraw();
            m2.redraw();
        }, 200);
    }).trigger('resize');

    jQuery('#sparkline').sparkline([4, 3, 3, 1, 4, 3, 2, 2, 3, 10, 9, 6], {
        type: 'bar',
        height: '30px',
        barColor: '#428BCA'
    });


    jQuery('#sparkline2').sparkline([9, 8, 8, 6, 9, 10, 6, 5, 6, 3, 4, 2], {
        type: 'bar',
        height: '30px',
        barColor: '#999'
    });

    // Chosen Select
    jQuery("select").chosen({
        'min-width': '100px',
        'white-space': 'nowrap',
        disable_search_threshold: 10
    });


    // Do not use the code below. It's for demo purposes only
    // var c = jQuery.cookie('change-skin');
    // if (jQuery('.panel-stat').length > 0 && c == 'dodgerblue') {
    //     jQuery('.panel-stat').each(function () {
    //         if ($(this).hasClass('panel-danger')) {
    //             $(this).removeClass('panel-danger').addClass('panel-warning');
    //         }
    //     });
    // }
    //
    // if (jQuery('#basicflot').length > 0 && c == 'greyjoy') {
    //     plot.setData([{
    //         data: uploads,
    //         color: '#dd5702',
    //         label: 'uploads',
    //         lines: {
    //             show: true,
    //             fill: true,
    //             lineWidth: 1
    //         },
    //         splines: {
    //             show: false
    //         }
    //     },{
    //       data: average,
    //       color:'#fff',
    //         label:'average',
    //         lines:{
    //             show: true,
    //             fill: true,
    //             lineWidth: 1
    //         },splines: {
    //             show: false
    //         }
    //     },
    //         {
    //             data: downloads,
    //             color: '#cc0000',
    //             label: 'Downloads',
    //             lines: {
    //                 show: true,
    //                 fill: true,
    //                 lineWidth: 1
    //             },
    //             splines: {
    //                 show: false
    //             }
    //         }]);
    //     plot.draw();
    // }

});