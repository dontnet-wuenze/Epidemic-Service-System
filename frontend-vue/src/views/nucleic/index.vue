<template>
  <div id="indexContainer">
    <el-row type="flex" class="row-bg" :gutter="30">
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/appointment')">师生预约<img src="/favicon.ico"></button></el-col>
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
<style scoped src="../../../public/css/index.css"></style>
