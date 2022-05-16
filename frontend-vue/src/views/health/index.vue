<template>
  <div id="indexContainer">
    <el-row type="flex" class="row-bg" :gutter="30">
      <el-col :span="3"><button class="grid-content" @click="jump('/health/attend')">健康打卡</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/health/statistic')">打卡统计</button></el-col>
      <el-col :span="3"><button class="grid-content" @click="jump('/health/passcode')">查看通行码</button></el-col>
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
