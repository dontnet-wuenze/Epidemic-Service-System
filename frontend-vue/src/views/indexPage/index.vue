<template>
    <el-main>
        <el-tabs v-model="activeName" @tab-click="handleClick" stretch>
          <el-tab-pane label="核酸检测" name="first">
            <NucleicIndex></NucleicIndex>
          </el-tab-pane>
          <el-tab-pane label="审批交互" name="second">配置管理</el-tab-pane>
          <el-tab-pane label="疫情监控" name="third">角色管理</el-tab-pane>
          <el-tab-pane label="健康打卡" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
    </el-main>
</template>

<script>
 import NucleicIndex from '@/views/nucleic/index.vue';
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
    NucleicIndex
  }
}
</script>

<style>

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
