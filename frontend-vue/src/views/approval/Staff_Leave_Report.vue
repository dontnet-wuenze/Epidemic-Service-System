<template>
  <el-scrollbar class="customScrollbar">
    <div class="container">
      <div class="scroll-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>教职工离校报备</h3></div>
      </div>
      <div class="scroll-container-form">
        <el-form ref="StaffLeaveForm" :label-position="labelPosition" :model="form" label-width="auto" :rules="rules">
          <el-row>
            <el-col :span="6">
              <el-form-item label="申请编号">
                <el-input v-model="form.id" readonly="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7" :offset="3">
              <el-form-item label="申请日期">
                <el-date-picker type="date" v-model="form.date" placeholder="请选择日期" readonly="true"></el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>基础信息</h4></div>
          <el-row>
            <el-col :span="5">
              <el-form-item label="姓名">
                <el-input v-model="form.name" readonly="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5" :offset="2">
              <el-form-item label="工号">
                <el-input v-model="form.staff_id" readonly="true"></el-input>
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
              <el-form-item label="所属学院/部门" prop="institute">
                <el-select v-model="form.institute" filterable clearable placeholder="请选择学院/部门">
                  <el-option
                    v-for="item in institutes"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="6" :offset="1">
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
          <el-form-item label="居住地址" prop="address">
            <el-input style="width: 400px" v-model="form.address" ></el-input>
          </el-form-item>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>离校信息</h4></div>
          <el-form-item label="离校日期" prop="leave_date">
            <el-date-picker type="date" v-model="form.leave_date" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="预计返校日期" prop="return_date">
            <el-date-picker type="date" v-model="form.return_date" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="往返交通工具" prop="vehicle">
            <el-select v-model="form.vehicle_kind">
              <el-option label="家庭自备车辆" value="family_car"></el-option>
              <el-option label="公共交通工具" value="public_transport"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item v-if="form.vehicle == 'public_transport'" label="具体车次" prop="transport_num">
            <el-input v-model="form.transport_num" style="width: 500px"></el-input>
          </el-form-item>
          <el-row>
            <el-form-item label="离校前往目的地" prop="location">
              <el-cascader :options="locations" v-model="form.location" @change="handleChange"></el-cascader>
            </el-form-item>
          </el-row>
          <el-row>
            <el-col span="10">
              <el-form-item label="具体地址" prop="address_1">
                <el-input v-model="form.address_1"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col span="10">
              <el-form-item label="事由" prop="reason_1">
                <el-input v-model="form.reason_1" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col span="12">
              <el-form-item label="备注">
                <el-input v-model="form.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>离校报备情况</h4></div>
            <el-form-item prop="promise">
              <el-checkbox v-model="form.promise" label="true">
                本人承诺：以上情况信息属实。离校后按照疫情防控要求做好个人健康管理，如实报告相关信息
              </el-checkbox>
            </el-form-item>
          <div class="submit-btn">
            <el-form-item>
              <el-button type="primary" @click="submitForm('StaffLeaveForm')">提交表单</el-button>
            </el-form-item>
          </div>
        </el-form>
      </div>
    </div>    
  </el-scrollbar>
</template>

<script>
import { regionData } from "element-china-area-data";

export default {
  name: "student_leave_report",
  data() {
    let validCascader = (rule, value, callback) => {
      if (this.form.location.length === 0) {
        callback(new Error('请选择所在地区'));
      } else {
        callback();
      }
    }
    let vlidator_transport_num = (rule, value, callback) => {
      if (this.form.vehicle == "public_transport") {
        if(!value) {
          callback(new Error('该栏不能为空'));
        } else {
          callback();
        }
      } else {
        callback();
      }
    }
    return {
      form: {
        id: '1145141919810',
        name: 'Lingsing',
        staff_id: '3190103176',
        date: Date.now(),
        location:[]
      },
      locations:regionData,
      //选项不完整，待完成
      institutes: [{
       value: 'BaoWeiChu',
       label: '安全保卫处' 
      },{
        value: 'BeiJing',
        label: '北京研究院'
      },{
        value: 'BenKe',
        label: '本科生院'
      },{
        value: 'CaiGou',
        label: '采购管理办公室'
      },{
        value: 'DangWei',
        label: '党委办公室(含保密办公室、信访办公室)'
      }],
      //校验，等待完善
      rules: {
        telenum: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        email: [
          { required: true, message: "该栏不能为空", trigger: "blur" },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        institute: [
          { required: true, message: "请选择所在学院", trigger: "change" }
        ],
        campus: [
          { required: true, message: "请选择所在校区", trigger: "change" }
        ],
        in_residence: [
          { required: true, message: "请选择是否住校", trigger: "change" }
        ],
        address: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        parent_name: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        parent_tele: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        tutor_name: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        tutor_tele: [
          { required: true, message: "该栏不能为空", trigger: "blur" }
        ],
        leave_date: [
          { required: true, message: "请选择日期", trigger: "change" }
        ],
        return_date: [
          { required: true, message: "请选择日期", trigger: "change" }
        ],
        vehicle: [
          { required: true, message: "请选择乘坐交通工具", trigger: "change"}
        ],
        transport_num: [
          { required: true, validator:vlidator_transport_num, trigger: "blur" }
        ],
        location: [
          { required: true, validator:validCascader, trigger: "change" }
        ],
        address_1: [
          { required: true, message: "该栏不能为空", trigger: "blur"}
        ],
        reason_1: [
          { required: true, message: "该栏不能为空", trigger: "blur"}
        ],
        promise: [
          { required: true, message: "请确认已知", trigger: "change" }
        ],
      }
    }
  },
  methods: {
    submitForm(form_name) {
      this.$refs[form_name].validate((valid) =>{
        if(valid) {
          this.$message.success('提交成功!');
        }
        else {
          this.$message.error('表单填写有误，请检查后重新提交!');
          return false;
        }
      });
    }
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

.cascade_box {

}
</style>