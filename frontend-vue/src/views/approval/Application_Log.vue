<template>
  <div>
    <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="log-container">
      <div class="log-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>申请记录</h3></div>
      </div>
      <el-table :data="tabledata" style="width: 75%; margin: auto" max-height="550">
        <el-table-column prop="applicant" label="申请人" width="150"></el-table-column>
        <el-table-column prop="application_time" label="申请时间" width="250"></el-table-column>
        <el-table-column prop="application_type" label="申请种类" width="150"></el-table-column>
        <el-table-column prop="audit_status" label="审核状态" width="200"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { get_application_log } from "@/api/approval"

export default {
  name: "applicaiton_log",
  data() {
    return{
      tabledata: []
    }
  },
  methods:{
      goOff(){
      this.$router.go(-1);
    }
  },
  async mounted() {
    let _this = this;
    get_application_log().then(res => {
      _this.tabledata = res.data.tabledata
    }).catch(error=> {
      console.log(error);
    })
  }
}
</script>


<style scoped>
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

.log-container {
  height: 100%;
  margin: 10px auto;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

.log-container-title{
  height: 150px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}
</style>