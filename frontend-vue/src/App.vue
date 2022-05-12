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
</style>
