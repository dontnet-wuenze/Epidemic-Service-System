<!-- template>
  <div id="app">
    <button @click="change('/')">首页</button>
    <button @click="change('/login')">登录</button>
    <router-view></router-view>
  </div>
</template-->
<template>
  <router-view></router-view>
</template>

<script>
  //import HelloWorld from "@/components/HelloWorld";
  export default {
    name: 'App',
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
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 100%;
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
