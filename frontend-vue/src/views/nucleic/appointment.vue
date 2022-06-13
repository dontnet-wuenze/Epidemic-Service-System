
<template>
 <el-scrollbar class="customScrollbar">
   <div class="container">
     <div class="scroll-container-title">
       <div style="display: flex; justify-content: center; align-items: center"><h3>核酸检测预约</h3></div>
     </div>
     <div class="scroll-container-form">
       <el-form ref="NucleicAppointmentForm" :label-position="labelPosition" :model="form" label-width="auto" :rules="rules">
         <el-row>
           <el-col :span="6">
             <el-form-item label="申请编号">
               {{form.form_id}}
             </el-form-item>
           </el-col>
           <el-col :span="7" :offset="3">
             <el-form-item label="申请日期">
               <el-date-picker type="date" v-model="form.date" placeholder="请选择日期" readonly="true"></el-date-picker>
             </el-form-item>
           </el-col>
         </el-row>
         <el-divider></el-divider>
         <div style="display:flex;"><h4>基础信息</h4></div>
         <el-row>
           <el-col :span="6">
             <el-form-item label="姓名" prop="name">
               <el-input v-model="form.name"></el-input>
             </el-form-item>
           </el-col>
           <el-col :span="6" :offset="1">
             <el-form-item label="工号" prop="staff_id">
               <el-input v-model="form.staff_id"></el-input>
             </el-form-item>
           </el-col>
         </el-row>
         <el-row>
            <el-col :span="6">
              <el-form-item label="手机号码" prop="telenum">
                <el-input v-model="form.telenum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6" :offset="1">
              <el-form-item label="邮箱地址" prop="email">
                <el-input v-model="form.email"></el-input>
              </el-form-item>
            </el-col>
         </el-row>
         <el-row>
           <el-col :span="6">
             <el-form-item label="所在校区" prop="campus">
                <el-select v-model="form.campus" filterable clearable placeholder="请选择校区">
                  <el-option label="紫金港校区 Zijingang" value="Zijingang"></el-option>
                  <el-option label="玉泉校区 Yuquan" value="Yuquan"></el-option>
                  <el-option label="西溪校区 Xixi" value="Xixi"></el-option>
                  <el-option label="华家池校区 Huajiachi" value="Huajiachi"></el-option>
                  <el-option label="之江校区 Zhijiang" value="Zhijiang"></el-option>
                  <el-option label="海宁校区 Haining" value="Haining"></el-option>
                  <el-option label="舟山校区 Zhoushan" value="Zhoushan"></el-option>
                  <el-option label="宁波校区 Ningbo" value="Ningbo"></el-option>
                  <el-option label="工程师学院 Polytechnic Institue" value="Polytechnic Institue"></el-option>
                  <el-option label="杭州国际科创中心 Innovation Center" value="Innovation Center"></el-option>
                </el-select>
              </el-form-item>
           </el-col>
         </el-row>
         <el-divider></el-divider>
         <div style="display:flex;"><h4>预约信息</h4></div>
          <el-form-item label="预约日期" prop="appDate">
            <el-date-picker type="date" v-model="form.appDate" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="预约监测点" prop="appAddress">
            <el-select v-model="form.appAddress" filterable clearable placeholder="请选择监测点">
              <el-option label="紫金港操场" value="Zijingang"></el-option>
              <el-option label="玉泉邵体馆" value="Yuquan"></el-option>
              <el-option label="西溪校医院" value="xixi"></el-option>
              <el-option label="海宁监测点" value="Haining"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="预约时间" prop="appTime">
            <el-select v-model="form.appTime" filterable clearable placeholder="请选择时间段">
              <el-option label="上午10:30-12:00" value="1"></el-option>
              <el-option label="下午1:30-3:00" value="2"></el-option>
              <el-option label="下午3:00-4:30" value="3"></el-option>
              <el-option label="下午4:30-6:00" value="4"></el-option>
            </el-select>
          </el-form-item>
          <el-divider></el-divider>
          <div class="submit-btn">
            <el-form-item>
              <el-button type="primary" @click="submitForm('NucleicAppointmentForm')">提交表单</el-button>
            </el-form-item>
          </div>
        </el-form>
     </div>
   </div>
 </el-scrollbar>
</template>

<script>

import {nucleicAppointment} from '@/api/nucleic.js';
import {nucleicGetAppointment} from '@/api/nucleic.js';

export default {
  name: "appointment",
  data() {
    return {
      form:{
        form_id: '',
        name: '',
        staff_id: '',
        date: Date.now(),
        appDate: "",
        appTime: "",
        appAddress: "",
        telenum: "",
        email: "",
        campus: ""
      },
      rules:{
        name: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        staff_id: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        telenum: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        email: [
          { required: true, message: "该栏不能为空", trigger: "blur" },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        campus: [
          { required: true, message: "请选择所在校区", trigger: "change" }
        ],
        appDate: [
          { required: true, message: "请选择预约日期", trigger: "change" }
        ],
        appAddress: [
          { required: true, message: "请选择预约地点", trigger: "change" }
        ],
        appTime: [
          { required: true, message: "请选择预约时间段", trigger: "change" }
        ],
      }
    };
  },
  async mounted(){
      let _this = this;
      nucleicGetAppointment().then(res=>{
        _this.form.form_id = res.data.form_id;
      })
  },
  methods: {
    submitForm(form_name) {
      this.$refs[form_name].validate((valid) =>{
        if(valid) {
          console.log(this.form)
          nucleicAppointment(this.form);

        }
        else {
          this.$message.error('表单填写有误，请检查后重新提交!');
          return false;
        }
      });
    },
  }
}
</script>

<style scoped>
.container{
  height: 100%;
  margin: 10px auto;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

.scroll-container-title{
  height: 150px;
  margin: 2rem auto;
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}

.scroll-container-form {
  width: 100%;
}
</style>

<style>
.customScrollbar{
  height:100%;
  width:100%;
}
.customScrollbar .el-scrollbar__wrap{
  overflow: scroll;
  overflow-x: hidden;
}

.customScrollbar .el-scrollbar__wrap::-webkit-scrollbar{
  display: none;
}

.submit-btn{
  margin-top: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
