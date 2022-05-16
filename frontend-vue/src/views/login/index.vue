// userLogin componen
<template>
  <div>
    <el-input style="width:200px" v-model="username"></el-input>
    <el-button @click="login">登录</el-button>
  </div>
</template>
<script>
import axios from 'axios'
import request from '@/utils/request'

export default {
  name: 'userLogin',
  data(){
    return {
      username: '',
    }
  },
  methods: {
    login(){
      // 这里触发vuex中的actions，在vuex中调用用户登陆接口
      // 从而将用户登陆之后的状态保存至vuex中

      this.$store.dispatch('login', this.username).then(() => {
        // 登陆成功之后，路由跳转至用户账户页或者进行你需要的操作
        this.$router.push({
          path: '/index',
          query: {
            date: new Date().getTime()
          }
        })
      });

    }
  }
}
</script>

<style scoped>

</style>
