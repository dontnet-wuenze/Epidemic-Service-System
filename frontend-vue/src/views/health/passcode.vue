<template>
  <div>
    <div class="title-container" style="height: 60px;">
      <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="passcode-container">
        <div class="content-box-title">
          <el-row :gutter="20" type="flex" justify="space-around">
            <el-col :span="6" :offset="1"><h3>{{user_name}}的通行码</h3></el-col>
            <el-col :span="8"><h3>{{user_department}}学院</h3></el-col>
            <el-col :span="3" class="content-box-title-grade"><span class="bgr-blue">{{user_grade}}</span></el-col>
          </el-row>
        </div>
        <strong>
          <div class="time-box">{{read_date}}</div>
        </strong>
        <div class="content-box-qr">
          <!--canvas width="200" height="200" id="qrcode"></canvas-->
          <img style="height: 250px; width: 250px" :src="code_addr[user_code]">
        </div>
        <div class="content-box-status">
          <div v-bind:class="{'blue-font': user_code===0, 'yellow-font': user_code===1, 'red-font': user_code===2}">通行码为: {{code_satatus[user_code]}}</div>
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
  </div>
</template>

<script>
const dayjs = require('dayjs');
import {userCode} from '@/api/user.js';

export default {
  name: "passcode",
  data() {
    return {
      user_name: '小明',
      user_department: '计算机科学与技术',
      user_grade: '本科生',
      user_code: 0,
      code_satatus: ['蓝码', '黄码', '红码'],
      code_addr: ['/img/health/qr-blue.png', '/img/health/qr-yellow.png', '/img/health/qr-red.png'],
      read_date: "",
    }
  },
  async mounted() {
    const loading = this.$loading({
      lock: true,
      text: 'Loading',
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)'
    });
    let _this = this; // 声明一个变量指向Vue实例this，保证作用域一致
    this.timer = setInterval(() => {
      _this.read_date = dayjs().format('MM月DD日 HH:mm:ss'); // 修改数据date
    }, 1000)
    userCode().then(res => {
      _this.user_code = res.data.code;
      _this.user_name = res.data.name;
      _this.user_department = res.data.department;
      _this.user_grade = res.data.grade;
      setTimeout(() => {
        loading.close();
      }, 1000);
    })
  },
  beforeDestroy() {
    if (this.timer) {
      clearInterval(this.timer); // 在Vue实例销毁前，清除我们的定时器
    }
  },
  methods: {
    goOff(){
      this.$router.go(-1);
    },
  }
}
</script>

<style scoped>

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

.blue-font{
  font-size: 20px;
  color: dodgerblue;
}

.yellow-font{
  font-size: 20px;
  color: orange;
}

.red-font{
  font-size: 20px;
  color: red;
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

.title-container {

}

.passcode-container {
  width: 100%;
  display: inline-block;
}

.button {
  position: absolute;
  z-index: 0;
  left: 20px;
  top: 10px;
  background-color: #ffffff;
  border:2px solid #008cba;
  border-radius:8px;
  font-size: 18px;
  color:  #87cefa;
  padding: 10px 20px;
  margin: 4px 2px;
  text-align: center;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

</style>
