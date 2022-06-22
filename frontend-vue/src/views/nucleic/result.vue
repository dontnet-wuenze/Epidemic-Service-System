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

import {nucleicResult} from '@/api/nucleic.js';

export default{
  name: "nucleicResult",
  async mounted(){
      let _this = this;
      nucleicResult().then(res=>{
        _this.name = res.data.name
        _this.staff_id = res.data.staff_id
        _this.user_result = res.data.result
        _this.result_time = res.data.appDate
        if(_this.user_result !== 0 && _this.user_result !== 1)
          _this.user_result = 2;
      })
  },
  data(){
    return {
      name:'',
      staff_id:'',
      user_result: '2',
      result_addr: ['/img/health/nu-neg.png', '/img/health/nu-pos.png', '/img/health/nu-ukn.png'],
      result_time: ''
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
