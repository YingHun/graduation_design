$(function () {
    $.ajax({
        type: "POST",
        url: "goods/report/list",
        async: false,
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            loadingChart(data);
        },
        error: function () {
            layer.msg("页面加载失败，请稍后重试", {time: 2000});
        }
    });
});

function loadingChart(data) {
    var charts = echarts.init(document.getElementById('charts'));

    var option = {
        backgroundColor: "#e6e6e6",
        title: {
            text: '最近七天商品销售报表'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['商品销售数量', '商品销售金额']
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                data: data.legend
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '销售数量（件）',
                min: 0,
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '销售金额（万元）',
                min: 0,
                position: 'right',
                axisLabel: {
                    formatter: '{value}',
                }
            }
        ],
        series: [
            {
                name: '销售数量',
                type: 'bar',
                itemStyle: {normal: {color: '#009688'}},
                data: data.quantity,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '销售金额',
                type: 'line',
                yAxisIndex: 1,
                itemStyle: {normal: {color: '#2ba2f4'}},
                data: data.money,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }
        ]
    };

    charts.setOption(option);
}