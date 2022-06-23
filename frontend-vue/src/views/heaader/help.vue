<template>
  <div class="help-box">
    <h2 style="height: 10%">帮助文档</h2>
    <iframe style="height: 90%; width: 100%" src="/help.html"></iframe>
  </div>
</template>

<script>
export default {
  name: "help.vue"
}
</script>

<style scoped>
.help-box {
  height: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
}
</style>
