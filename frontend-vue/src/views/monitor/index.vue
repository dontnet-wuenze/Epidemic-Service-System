<template>
  <div id="indexContainer">
    <el-row type="flex" class="row-bg" gutter="30">
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/appointment')">全校核酸检测扫码统计<img src="/favicon.ico"></button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/result')">本科生核酸情况统计</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/nucleic/upload')">在校人数分析</button></el-col>
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
