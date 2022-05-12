<!--template>
    <el-main >
      <el-tabs v-model="activeName" @tab-click="handleClick" stretch>
        <el-tab-pane label="核酸检测" name="first">
          <NucleicIndex></NucleicIndex>
        </el-tab-pane>
        <el-tab-pane label="审批交互" name="second">
          <ApprovalIndex></ApprovalIndex>
        </el-tab-pane>
        <el-tab-pane label="疫情监控" name="third">
          <MonitorIndex></MonitorIndex>
        </el-tab-pane>
        <el-tab-pane label="健康打卡" name="fourth">
          <HealthIndex></HealthIndex>
        </el-tab-pane>
      </el-tabs>
    </el-main>
</template-->

<template>
    <el-tabs v-model="activeName" @tab-click="handleClick" stretch>
      <el-tab-pane label="核酸检测" name="first">
        <NucleicIndex></NucleicIndex>
      </el-tab-pane>
      <el-tab-pane label="审批交互" name="second">
        <ApprovalIndex></ApprovalIndex>
      </el-tab-pane>
      <el-tab-pane label="疫情监控" name="third">
        <MonitorIndex></MonitorIndex>
      </el-tab-pane>
      <el-tab-pane label="健康打卡" name="fourth">
        <HealthIndex></HealthIndex>
      </el-tab-pane>
    </el-tabs>
</template>

<script>
 import NucleicIndex from '@/views/nucleic/index.vue';
 import ApprovalIndex from '@/views/approval/index.vue';
 import MonitorIndex from '@/views/monitor/index.vue';
 import HealthIndex from '@/views/health/index.vue';

export default {
  name: 'Index',
  data() {
    return {
      activeName: 'first',
    }
  },
  methods: {
    jump (name) {
      this.$router.push({name: name})
    }
  },
  components: {
    NucleicIndex,
    ApprovalIndex,
    MonitorIndex,
    HealthIndex
  }
}
</script>

<style scoped>

.blue-bg{
  background: url('../../../public/img/health/blue-bg.png') no-repeat left top;
  background-size: 100% auto;
  width:100%;
}

.banner {
  width: 100%;
  text-align: center;
  margin: 40px 0;
}

.content-box {
  width: 70%;
  height: 600px;
  border-radius: 10px;
  box-shadow: 0 0 8px rgb(0 0 0 / 40%);
  background: #fff;
  margin: 0 auto;
  position: relative;
}

.main-container {
  position: relative;
  left: 0;
  right: 0;
}
.el-row {
  margin-bottom: 20px;
  width: 100%;
}
.el-col {
  border-radius: 4px;
}

.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  width: 100%;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 100%;
  height: auto;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

::v-deep .el-tabs__nav-scroll{
  width:50%;
  margin:0 auto
}

</style>
