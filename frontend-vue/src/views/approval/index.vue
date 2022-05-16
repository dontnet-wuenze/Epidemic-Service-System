<template>
  <div id="indexContainer">
    <el-row type="flex" class="row-bg" :gutter="30">
      <el-col :span="3"><button class="grid-content" @click="jump('/approval/Student_Leave_Report')">学生离校报备<img src="/favicon.ico"></button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/result')">教职工离校报备</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/upload')">学生通行码申请</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/appointment')">教职工通行码申请<img src="/favicon.ico"></button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/result')">申请记录</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/upload')">表单审批列表</button></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'Index',
  methods: {
    jump(path) {
      this.$router.push(path)
    }
  }
}
</script>
<style scoped src="../../../public/css/index.css"></style>
