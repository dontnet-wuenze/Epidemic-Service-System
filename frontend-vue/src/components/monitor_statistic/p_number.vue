<template>
<div>
  <div class="people-list-title">
      <h2>全校核酸检测人员统计</h2>
    </div>
  <div style="width:100%;height:30px;text-align: center;">
    <div style="height:30px;width:100%;"></div>
  </div>
  
  <div style="width: 100%;height: 300px;margin-left: 20%;margin-top: 10%;" >
    <div id="main" style="width: 600px;height: 300px;align-items: center;"></div>
  </div>
   
</div>
</template>
<script>
import * as echarts from "echarts";
<<<<<<< HEAD
 
=======
import request from '@/utils/request'

>>>>>>> develop
export default {
  data() {
    return {
      xData: ["紫金港", "玉泉", "西溪", "之江", "华家池", "海宁", "舟山"], //横坐标
      yData: [23, 24, 18, 25, 27, 28, 25], //人数数据
      taskDate: [10, 11, 9, 17, 14, 13, 14],
      myChartStyle: { float: "left", width: "100%", height: "400px" }, //图表样式
      charts: '',
<<<<<<< HEAD
          opinion:['全校已完成','全校未完成'],
          opinionData:[
            {value:335, name:'全校已完成'},
            {value:310, name:'全校未完成'},
                
          ]
=======
      opinion:['全校已完成','全校未完成'],
      opinionData:[]
>>>>>>> develop
    };
  },
  name: '',
  mounted() {
<<<<<<< HEAD
    this.$nextTick(function() {
                this.drawPie('main')
            })
  },
  methods: {
=======
    const axios = require('axios');
    this.$nextTick(function() {
                this.drawPie('main')
            })
    this.getnumber().then(res => {
      this.opinionData = res.data.data
    })
  },
  methods: {
    getnumber() {
      return request({
          url: '/api/monitor/w_number',
          method: 'get',
      })
    },
>>>>>>> develop
    goOff(){
            this.$router.go(-1);
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