<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <script type="text/javascript">
        $(function(){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            $.ajax({
                url: '${pageContext.request.contextPath}/user/showCountByDate',
                success: function(data){
                   console.log(data)
                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: 'cmfz活跃用户'
                        },
                        tooltip: {},
                        legend: {
                            data:['柱状','折线']
                        },
                        xAxis: {
                            data: ["近一周","近两周","近三周"]
                        },
                        yAxis: {},
                        series: [{
                            name: '柱状',
                            type: 'bar',
                            data: data
                        },{
                            name: '折线',
                            type: 'line',
                            data: data,
                            color:'#2f4554'
                        }]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });

        });
    </script>

    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>

