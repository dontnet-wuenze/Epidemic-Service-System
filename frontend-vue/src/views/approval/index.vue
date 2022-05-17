<template>
  <div id="indexContainer">
    <div class="grid-content" @click="jump('/approval/Student_Leave_Report')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/leaveStudent.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>学生离校报备</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/nucleic/result')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/workerLeave.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>教职工外出报备</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/nucleic/upload')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/passStudent.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>学生通行码申请</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/nucleic/appointment')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/workerReturn.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>教职工返校申请</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/nucleic/result')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon/approvalRecord.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>申请记录</p>
      </div>
    </div>
    <div class="grid-content" @click="jump('/nucleic/upload')">
      <div class="grid-top">
        <div class="grid-circle">
          <div class="grid-icon">
            <img src="/img/icon//approvalList.png" alt="" style="height: 100%; width: 100%">
          </div>
        </div>
      </div>
      <div class="grid-font">
        <p>表单审批列表</p>
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
