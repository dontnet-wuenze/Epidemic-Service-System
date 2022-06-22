<template>
    <div>
        <div class="people-list-title">
            <h2>本科生一周内核酸检测统计</h2>
        </div>
        <br>
        <br>
        <br>
       <div id="myChart" :style="{width: '1000px', height: '500px'}"></div>
    </div>
</template>
<script>
import * as echarts from "echarts";
import request from '@/utils/request'
    // 引入基本模板
    export default {
        name: "DataCount",
        data: () => ({
            b_number_data : []
        }),
        mounted(){
            this.drawLine();
            this.get_b_number().then(res => {
                this.b_number_data = res.data.data
            })
        },
        methods:{
        get_b_number() {
            return request({
                url: '/monitor/under_number',
                method: 'get',
            })
        },
        goOff(){
            this.$router.go(-1);
        },
            drawLine(){
                // 基于准备好的dom，初始化echarts实例
                let myChart = echarts.init(document.getElementById('myChart'));
                // 绘制图表
                myChart.setOption({
                    title: {
                        text: '',
                        subtext: ''
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['未完成检测','完成检测']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            dataView: {readOnly: false},
                            magicType: {type: ['line', 'bar']},
                            restore: {},
                            saveAsImage: {}
                        }
                    },
                    xAxis:  {
                        type: 'category',
                        boundaryGap: false,
                        data: ['2019-02-25','2019-03-04','2019-03-18','2019-03-26','2019-04-16','2019-04-26','2019-05-04']
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    },
                    series: [
                        {
                            name:'未完成检测',
                            type:'line',
                            data:[11, 11, 15, 13, 12, 13, 10],
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
                            name:'完成检测',
                            type:'line',
                            data:[1, -2, 2, 5, 3, 2, 0],
                            markPoint: {
                                data: [
                                    {name: '周最低', value: 2, xAxis: 1, yAxis: 1.5}
                                ]
                            },
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'},
                                    [{
                                        symbol: 'none',
                                        x: '90%',
                                        yAxis: 'max'
                                    }, {
                                        symbol: 'circle',
                                        label: {
                                            normal: {
                                                position: 'start',
                                                formatter: '最大值'
                                            }
                                        },
                                        type: 'max',
                                        name: '最高点'
                                    }]
                                ]
                            }
                        }
                    ]
                });
            }
        }
    }
</script>
<style scoped>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
    }
    .button {
    position: relative;
    background-color: #ffffff;
	border:2px solid #008cba;
    border-radius:8px;
    font-size: 18px;
    color:  #87cefa;
    padding: 10px 20px;
    margin: 4px 2px;
    text-align: center;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    text-decoration: none;
    overflow: hidden;
    cursor: pointer;
}

.button:after {
    content: "";
    background: #a9a9a9;
    display: block;
    position: absolute;
    padding-top: 300%;
    padding-left: 350%;
    margin-left: -20px!important;
    margin-top: -120%;
    opacity: 0;
    transition: all 0.8s
}
.people-list-title {
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid #e5e5e5;
}
.button:active:after {
    padding: 0;
    margin: 0;
    opacity: 1;
    transition: 0s
}
</style>
