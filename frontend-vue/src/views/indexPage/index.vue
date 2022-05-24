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
    <el-tabs v-model="activeName" stretch class="new-tabs-header">
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
    HealthIndex,
  }
}
</script>

<style lang="scss" scoped>

::v-deep .el-tabs__nav-scroll{
  width:70%;
  margin:0 auto;
  height: 80px;
}

::v-deep .el-tabs__nav {
  height: 80px;
}

::v-deep .el-tabs__active-bar.is-top {
  width: 230px;
}

::v-deep .el-tabs__item {
  height: 80px;
  width: 60px;
  line-height: 80px;
  font-size: 20px;
}

</style>
