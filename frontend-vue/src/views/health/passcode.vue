<template>
  <div>
      <div class="content-box-title">
        <el-row :gutter="20" type="flex" justify="center">
          <el-col :span="6" :offset="1"><h3>吴恩泽的通行码</h3></el-col>
          <el-col :span="8"><h3>计算机科学与技术学院</h3></el-col>
          <el-col :span="3" class="content-box-title-grade"><span class="bgr-blue">本科生</span></el-col>
        </el-row>
      </div>
      <strong>
        <div class="time-box">05月12日 14:31:26</div>
      </strong>
      <div class="content-box-qr">
        <!--canvas width="200" height="200" id="qrcode"></canvas-->
        <img style="height: 250px; width: 250px" src="/img/health/qr.png">
      </div>
      <div class="content-box-status">
        <div class="status-font">健康码为: 绿码</div>
      </div>
      <div class="content-box-label">
        <div class="label-font">
          凭蓝码可在浙江大学校园内通行
          <br>
          请主动出示，配合检查</div>
      </div>
      <div class="content-box-jump">
        <el-row :gutter="20" type="flex" justify="center">
          <el-col :span="3">申请流程</el-col>
          <el-col :span="3">申请记录</el-col>
        </el-row>
      </div>
    </div>
</template>

<script>
export default {
  name: "passcode"
}
</script>

<style scoped>
.blue-bg{
  background: url('../../../public/img/health/blue-bg.png') no-repeat left top;
  background-size: 100% auto;
  width:100%;
}

.banner {
  width: 100%;
  text-align: center;
  margin: 40px 0;
}

.content-box {
  width: 70%;
  height: 600px;
  border-radius: 10px;
  box-shadow: 0 0 8px rgb(0 0 0 / 40%);
  background: #fff;
  margin: 0 auto;
  position: relative;
}

.content-box-title {
  width: 90%;
  margin: 0 auto;
  line-height: 2rem;
}

.content-box-title h3 {
  font-size: 1.3rem;
  color: #333;
  width: 70%;
  float: left;
}

.content-box-title-grade {
  display: flex;
  justify-content: center;
  align-items: center;
}

.bgr-blue {
  background: #028aff;
  font-size: 18px;
  padding: 3px;
  color: white;
}

.time-box {
  /* width: 90%; */
  margin: 5px;
  text-align: center;
  line-height: 48px;
  font-size: 3rem;
  color: black;
  /* font-weight: bold; */
}

.content-box-qr {
  /* width: 70%; */
  /* margin: 15px auto; */
  text-align: center;
  margin: 15px auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.content-box-status {
  width: 90%;
  text-align: center;
  margin: 15px auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.status-font{
  font-size: 20px;
  color: forestgreen;
}

.content-box-label {
  width: 90%;
  text-align: center;
  margin: 15px auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

.content-box-jump {
  width: 90%;
  text-align: center;
  margin: 15px auto;
  display: flex;
  justify-content: center;
  align-items: center;
}

</style>
