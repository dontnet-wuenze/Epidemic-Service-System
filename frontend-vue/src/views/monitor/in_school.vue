<template>
<div>
  <div class="people-list-title">
      <h2>在校人数统计</h2>
    </div>
  <div style="width:100%;height:30px;text-align: center;">
    <div style="height:30px;width:100%;"></div>
  </div>
  <div  style="width: 100%;height: 400px">
    <div class="echart" id="mychart" :style="myChartStyle"></div>
  </div>
  <div style="width: 100%;height: 100%;margin-left: 28%;" >
    <div id="main" style="width: 600px;height: 300px;align-items: center;"></div>
  </div>

</div>
</template>

<script>
import * as echarts from "echarts";
import request from '@/utils/request'
export default {
  data() {
    return {
      xData: ["紫金港", "玉泉", "西溪", "之江", "华家池", "海宁", "舟山"], //横坐标
      yData: [], //人数数据
      taskDate: [],
      myChartStyle: { float: "left", width: "100%", height: "400px" }, //图表样式
      charts: '',
          opinion:['在校总人数','不在校总人数'],
          opinionData:[
            {},
            {},

          ]
    };
  },
  name: '',
  mounted() {
    this.initEcharts();
    this.$nextTick(function() {
                this.drawPie('main')
            })
    this.get_number().then(res => {
      this.yData = res.data.data
    })
  },
  methods: {
    get_number() {
      return request({
          url: '/monitor/in_school',
          method: 'get',
      })
    },
    goOff(){
            this.$router.go(-1);
        },
    initEcharts() {
      // 多列柱状图
      const mulColumnZZTData = {
        xAxis: {
          data: this.xData
        },
        // 图例
        legend: {
          data: ["在校人数", "不在校人数"],
          top: "0%"
        },
        yAxis: {},
        series: [
          {
            type: "bar", //形状为柱状图
            data: this.yData,
            name: "在校人数", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          },
          {
            type: "bar", //形状为柱状图
            data: this.taskDate,
            name: "不在校人数", // legend属性
            label: {
              // 柱状图上方文本标签，默认展示数值信息
              show: true,
              position: "top"
            }
          }
        ]
      };
      const myChart = echarts.init(document.getElementById("mychart"));
      myChart.setOption(mulColumnZZTData);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    },
    drawPie(id){
               this.charts = echarts.init(document.getElementById(id))
               this.charts.setOption({
                 tooltip: {
                   trigger: 'item',

                 },
                 legend: {
                   orient: 'vertical',
                   x: 'left',
                   data:this.opinion
                 },
                 series: [
                   {
                     name:'人数',
                     type:'pie',
                     radius:['50%','70%'],
                     avoidLabelOverlap: false,
                     label: {
                       normal: {
                         show: false,
                         position: 'center'
                       },
                       emphasis: {
                         show: true,
                         textStyle: {
                           fontSize: '30',
                           fontWeight: 'blod'
                         }
                       }
                     },
                     labelLine: {
                       normal: {
                         show: false
                       }
                     },
                     data:this.opinionData
                   }
                 ]
               })
            }
  }
};
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
