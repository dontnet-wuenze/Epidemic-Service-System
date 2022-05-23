<template>
  <div>
    <div class="content-box-title">
      <el-row :gutter="20" type="flex" justify="space-around"><h2>核酸检测查询</h2></el-row>
    </div>
    <div class="content-box-nucleic">
      <el-row class="content-box-nucleic-header"><h3>您的核酸结果是</h3></el-row>
      <p  style="text-align: center;">
        <img style="height: 200px; width: 200px" :src="result_addr[user_result]" >
      </p>
      <el-divider></el-divider>
      <el-row class="textGray">
        <el-col :span="13" :offset="3"><h3>姓名: {{name}}</h3></el-col>
        <el-col :span="8"><h3>学号: {{staff_id}}</h3></el-col>
      </el-row>
      <el-row class="textGray">
        <el-col :span="13" :offset="3"><h3>检测时间: {{result_time}}</h3></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default{
  name: "nucleicResult",
  data(){
    return {
      name:'李田所',
      staff_id:'3190101919',
      user_result: 1,
      result_addr: ['/img/health/nu-neg.png', '/img/health/nu-pos.png'],
      result_time: "2022-5-19 14:36:00"
    }
  }
}
</script>


<style scoped>
.content-box-title h3 {
  font-size: 1.3rem;
  color: #333;
  width: 70%;
  float: left;
}

.content-box-nucleic {
  width: 70%;
  height: 500px;
  border-radius: 10px;
  box-shadow: 0 0 8px rgb(0 0 0 / 40%);
  background: #fff;
  margin: 0 auto;
  position: relative;
}

.content-box-nucleic-header {
  text-align: center;
  color: #666;
}

.textGray {
  color: #666;
}

</style>