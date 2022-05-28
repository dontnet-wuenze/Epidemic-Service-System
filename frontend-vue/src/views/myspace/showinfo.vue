<template>
<div>
    <div  style="width:14%;height: 130px;border-radius: 100px;display:inline-block;">
      <img
        style="width:100%;height: 100%;border-radius: 100px"
        src="/img/fly.jpg"
        class="image"
      >
    </div>

  <br>
  <br>
  <el-descriptions :column="1" border>

    <el-descriptions-item label="用户名" v-model="username" ><p class="message">{{username}}</p></el-descriptions-item>
    <el-descriptions-item label="邮箱号" v-model="email" class="message"><p class="message">{{email}}</p></el-descriptions-item>
    <el-descriptions-item label="性别" v-model="sex" class="message"><p class="message">{{sex}}</p></el-descriptions-item>
    <el-descriptions-item label="座右铭" v-model="motto" class="message" ><p class="message">{{motto}}</p></el-descriptions-item>
    <el-descriptions-item label="家乡" v-model="hometown" class="message"><p class="message">{{hometown}}</p></el-descriptions-item>

  </el-descriptions>
</div>
</template>

<script>
export default {
  name: "showinfo",
  data(){
    return{
      username: "cs_liu",
      email: "cs_liu@zju.edu.cn",
      motto: "一生温暖纯良，不负爱与自由",
      hometown: "湖北鄂州",
      sex: "男"


    }
  }
}
</script>

<style scoped>
.message{
  width: 20em;
  overflow: hidden;
  text-overflow:ellipsis;
  white-space: nowrap;
}
</style>

