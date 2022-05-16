<template>
  <div id="indexContainer">
    <div class="grid-content" @click="jump('/monitor/whole_school')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/appointment.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>全校核酸检测扫码统计</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/monitor/Undergraduate')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/nucleicResult.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>本科生核酸情况统计</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/monitor/in_school')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon//nucleicUpload.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>在校人数分析</p>
      </div>
    </div>
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
