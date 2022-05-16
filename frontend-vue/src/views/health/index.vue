<template>
  <div id="indexContainer">
    <div class="grid-content" @click="jump('/health/attend')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/attend.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>健康打卡</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/health/statistic')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/statistic.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>打卡统计</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/health/passcode')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/passcode.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>查看通行码</p>
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
