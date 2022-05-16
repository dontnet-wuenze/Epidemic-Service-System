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
    components: {
      //HelloWorld
    },
    mounted () {
      // 全局监听刷新，刷新就执行saveState写入本地缓存
      window.addEventListener('unload', this.saveState)
    },
    methods: {
      saveState () {
        // 缓存vuex的state数据
        localStorage.setItem('state', JSON.stringify(this.$store.state))
      }
    }
  }
</script>

<style>
</style>
