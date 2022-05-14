<template>
  <div class="people-number-container">
    <div class="people-number-title">
      <h2>每日打卡人数统计</h2>
    </div>
    <div class="modeSelectoin">
      <el-radio-group v-model="graphMode">
        <el-radio-button label="peopleNubmer-Bar">柱状图</el-radio-button>
        <el-radio-button label="peopleNubmer-Pie">饼状图</el-radio-button>
      </el-radio-group>
    </div>
    <div class="display">
      <!-- echarts图表绘制在这里 -->
      <div v-show="graphMode === 'peopleNubmer-Bar'" id="peopleNumber-Bar" style="width: 600px; height: 400px;"></div>
      <div v-show="graphMode === 'peopleNubmer-Pie'" id="peopleNumber-Pie" style="width: 600px; height: 400px;"></div>
      <!--div id="canvas" style="width: 600px;height:400px;"></div-->
    </div>
  </div>
</template>

<script>

import * as echarts from 'echarts';

export default {
  name: "peopleNumber",
  data () {
    return {
      graphMode: 'peopleNubmer-Bar'
    }
  },
  mounted() {
    var barChart = echarts.init(document.getElementById('peopleNumber-Bar'));
    barChart.setOption({
      title: {
        text: '本学院打卡人数统计',
        subtext: '2022-5-20',
        left: 'center'
      },
      tooltip: {},
      xAxis: {
        type: 'category',
        data: ['已打卡', '未打卡']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          name: '人数',
          type: 'bar',
          barWidth: 40,
          label: {
            normal: {
              show: true,
              position: 'top'
            }
          },
          data: [
            {
              value: 100,
              itemStyle: {
                normal: {
                  color: '#00FF00'
                }
              }
            },
            {
              value: 20,
              itemStyle: {
                normal: {
                  color: '#FF0000'
                }
              }
            }
          ]
        }
      ]
    });

    // 根据准备好的dom初始化echarts实例
    var pieChart = echarts.init(document.getElementById('peopleNumber-Pie'));

    // 使用刚才指定的配置项和数据显示图表
    pieChart.setOption({
      title: {
        text: '本学院打卡人数统计',
        subtext: '2022-5-20',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        x:'left',
        y:'center'
      },
      series: [{
        name: '本学院打卡人数统计',
        type: 'pie',
        radius: '50%',
        data: [
          { value: 1048, name: '已打卡' },
          { value: 100, name: '未打卡' },
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
.people-number-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.people-number-title {
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
