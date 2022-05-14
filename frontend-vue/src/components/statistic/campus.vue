<template>
  <div class="campus-container">
    <div class="campus-title">
      <h2>打卡校区统计</h2>
    </div>
    <div class="modeSelectoin">
      <el-radio-group v-model="graphMode">
        <el-radio-button label="campus-Bar">柱状图</el-radio-button>
        <el-radio-button label="campus-Pie">饼状图</el-radio-button>
      </el-radio-group>
    </div>
    <div class="display">
      <!-- echarts图表绘制在这里 -->
      <div v-show="graphMode === 'campus-Bar'" id="campus-Bar" style="width: 600px; height: 400px;"></div>
      <div v-show="graphMode === 'campus-Pie'" id="campus-Pie" style="width: 600px; height: 600px;"></div>
      <!--div id="canvas" style="width: 600px;height:400px;"></div-->
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: "campus",
  data () {
    return {
      graphMode: 'campus-Bar'
    }
  },
  mounted() {
    var barChart = echarts.init(document.getElementById('campus-Bar'));
    barChart.setOption({
      title: {
        text: '打卡人员校区统计',
        subtext: '2022-5-20',
        left: 'center'
      },
      tooltip: {},
      xAxis: {
        type: 'category',
        data: ['紫金港校区', '玉泉校区', '西溪校区', '华家池校区', '之江校区', '海宁校区', '舟山校区', '宁波校区', '工程师学院',
               '杭州国际科创中心'],
        splitLine: {
          show: false
        },
        axisTick: {
          alignWithLabel: true
        },
        axisLabel: {
          interval: 0,
          rotate: 40,
        },
      },
      yAxis: {
        type: 'value',
        splitLine: {
          show: false
        },
        splitArea: {
          show: true,
        }
      },
      series: [
        {
          name: '人数',
          type: 'bar',
          label: {
            normal: {
              show: true,
              position: 'top'
            }
          },
          itemStyle: {
            normal: {
              // 随机显示
              //color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}

              // 定制显示（按顺序）
              color: function(params) {
                var colorList = ['#C33531','#EFE42A','#64BD3D','#EE9201','#29AAE3', '#B74AE5','#0AAF9F','#E89589','#16A085','#4A235A','#C39BD3 ','#F9E79F','#BA4A00','#ECF0F1','#616A6B','#EAF2F8','#4A235A','#3498DB' ];
                return colorList[params.dataIndex]
              }
            },
          },
          data: [120, 132, 101, 134, 90, 230, 210, 120, 150, 80]
        }
      ]
    });

    // 根据准备好的dom初始化echarts实例
    var pieChart = echarts.init(document.getElementById('campus-Pie'));

    // 使用刚才指定的配置项和数据显示图表
    pieChart.setOption({
      title: {
        text: '打卡人员校区统计',
        subtext: '2022-5-20',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      series: [{
        name: '人数',
        type: 'pie',
        radius: '60%',
        center: ['50%', '45%'],
        data: [
          { value: 120, name:'紫金港校区' },
          { value: 132, name:'玉泉校区' },
          { value: 101, name:'西溪校区' },
          { value: 134, name:'华家池校区' },
          { value: 90, name:'之江校区' },
          { value: 230, name:'海宁校区' },
          { value: 210, name:'舟山校区' },
          { value: 120, name:'宁波校区' },
          { value: 150, name:'工程师学院' },
          { value: 80, name:'杭州国际科创中心' },
          { value: 10, name:'其他' }
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
      ]
    });
  }
}
</script>

<style scoped>
.campus-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.campus-title {
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid #e5e5e5;
}

.modeSelectoin{
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.display{
  margin-top: 20px;
}
</style>
