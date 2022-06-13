<template>
  <div id="indexContainer">
    <div class="grid-content" @click="jump('/myspace/showinfo')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/showinfo_img.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <div>个人信息</div>
      </div>
    </div>
    <div class="grid-content" @click="jump('/myspace/infoeditor')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/infoeditor_img.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <div>信息修改</div>
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