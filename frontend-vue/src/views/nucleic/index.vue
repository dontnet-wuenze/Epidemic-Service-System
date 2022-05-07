<template>
  <div id="indexContainer">
    <el-row type="flex" class="row-bg" gutter="30">
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/appointment')">师生预约</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/result')">师生结果查询</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/upload')">结果上传</button></el-col>
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

<style>
  #indexContainer {
    text-align: center;
    height: 200px;
    padding: 10px;
    color: transparent;
  }
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    height: 100px;
    width: 100%;
  }
  .row-bg {
    height: 100%;
    padding: 10px;
    padding-left: 20px;
  }
</style>


