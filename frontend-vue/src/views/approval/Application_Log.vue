<template>
  <div>
    <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="log-container">
      <div class="log-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>申请记录</h3></div>
      </div>
      <el-table :data="tabledata" style="width: 100%" max-height="550">
        <el-table-column prop="applicant" label="申请人" width="150"></el-table-column>
        <el-table-column prop="application_time" label="申请时间" width="250"></el-table-column>
        <el-table-column prop="application_type" label="申请种类" width="150"></el-table-column>
        <el-table-column prop="audit_status" label="审核状态" width="200"></el-table-column>
        <el-table-column prop="valid_duration" label="有效时间" width="250"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  name: "applicaiton_log",
  data() {
    return{
      tabledata: [{
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-27 9:12:35',
        application_type: '离校申请',
        audit_status: '通过',
        valid_duration: '2020-5-27 - 2020-6-1'
      }, {
        applicant: '张三',
        application_time: '2020-6-2 11:42:54',
        application_type: '返校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-6-7 13:43:46',
        application_type: '返校申请',
        audit_status: '通过',
        valid_duration: '2020-6-7 - 2020-6-31'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      }, {
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '离校申请',
        audit_status: '辅导员审核',
        valid_duration: '暂无'
      },
      ]
    }
  },
  methods:{
      goOff(){
      this.$router.go(-1);
    }
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