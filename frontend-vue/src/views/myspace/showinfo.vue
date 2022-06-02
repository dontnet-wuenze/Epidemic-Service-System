<template>
<div class="info-box">
  <el-row>
    <el-col :span="6">
      <img src="/favicon.ico">
    </el-col>
    <el-col :offset="3" :span="15">
      <el-descriptions title="个人信息" :column="2">

        <el-descriptions-item label="学号">{{id}}</el-descriptions-item>
        <el-descriptions-item label="姓名">{{username}}</el-descriptions-item>
        <el-descriptions-item label="学院">{{department}}</el-descriptions-item>
        <el-descriptions-item label="专业">{{major}}</el-descriptions-item>
        <el-descriptions-item label="班级">{{cclass}}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{phone}}</el-descriptions-item>


      </el-descriptions>
    </el-col>

  </el-row>
</div>
</template>

<script>
import  {userInfo} from "@/api/user";

export default {
  name: "showinfo",
  data(){
    return{
      id: '3190100000',
      username: "cs_liu",
      department: "计算机科学与技术学院",
      major: "计算机科学与技术",
      cclass: "1904",
      phone: '13991391032',
    }
  },
  async mounted() {
    userInfo().then(res=> {
      this.id = res.data.id
      this.username = res.data.name
      this.department = res.data.department
      this.major = res.data.major
      this.cclass = res.data.class
      this.phone = res.data.phone
    })
  }
}
</script>

<style scoped lang="scss">

::v-deep tbody {
  height: 100px;
  font-size: 18px;
}

::v-deep .el-descriptions__header{
  margin-bottom: 40px;
}

::v-deep .el-descriptions__title {
  font-size: 21px;
}

.info-box {
  padding-top: 60px;
  padding-left: 100px;
}

.d-item {
  padding-top: 30px;
}

</style>

