<template>
  <el-container style="min-width: 1200px">
    <el-header>
      <el-row>
        <el-col :span="4" offset="3">浙江大学疫情服务与管理系统</el-col>
        <el-col :span="0.01">|</el-col>
        <el-col :span="1"><div @click="change('/index')" style="cursor: pointer">主页</div></el-col>
        <el-col :span="1" ><div @click="change('/health/attend')" style="cursor: pointer">打卡</div></el-col>
        <el-col :span="8" :offset="6">
          <div><button @click="change('/login')">登录</button></div>
        </el-col>
      </el-row>
    </el-header>
    <body class="blue-bg">
      <div class="banner">
        <img src="/img/health/text.png">
      </div>
      <div class="content-box">
        <keep-alive>
         <router-view></router-view>
        </keep-alive>
      </div>
    </body>
  </el-container>
</template>

<script>
//import HelloWorld from "@/components/HelloWorld";
export default {
  name: 'Header',
  methods: {
    change (path) {
      this.$router.push(path)
    }
  },
  components: {
    //HelloWorld
  }
}
</script>

<style>
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
  width: 90%;
  height: 750px;
  border-radius: 10px;
  box-shadow: 0 0 8px rgb(0 0 0 / 40%);
  background: #fff;
  margin: 0 auto;
  position: relative;
}

.el-row {
  margin-bottom: 20px;
  width: 100%;
}
.el-col {
  border-radius: 4px;
}

.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  width: 100%;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background: url('../../../public/img/health/blue-bg.png') no-repeat left top;
  background-size: 100% auto;
  width:100%;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}


</style>
