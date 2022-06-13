<template>
  <el-scrollbar class="customScrollbar">
    <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="container">
      <div class="scroll-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>学生通行码申请</h3></div>
      </div>
      <div class="scroll-container-form">
        <el-form ref="StuPassphraseApplication" :label-position="labelPosition" :model="form" :rules="rules">
          <el-row>
            <el-col :span="6">
              <el-form-item label="申请编号">
                <el-input v-model="form.id" readonly="true" style="width: 220px"></el-input>
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
                <el-input v-model="form.name" readonly="true" style="width: 200px"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5" :offset="2">
              <el-form-item label="学号">
                <el-input v-model="form.stu_id" readonly="true" style="width: 200px"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="手机号码" prop="telenum">
                <el-input v-model="form.telenum" style="width: 220px"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6" :offset="1">
              <el-form-item label="邮箱地址" prop="email">
                <el-input v-model="form.email" style="width: 220px"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="所在学院" prop="institute">
                <el-select v-model="form.institute" filterable clearable placeholder="请选择学院">
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
          <el-form-item label="是否住校" prop="in_residence">
            <el-radio-group v-model="form.in_residence">
              <el-radio label="true">是</el-radio>
              <el-radio label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="辅导员列表" prop="counsellor">
            <el-select v-model="form.counsellor" clearable filterable placeholder="请选择辅导员">
              <el-option
                v-for="item in counsellors"
                :key="item.value"
                :label="item.label"
                :value="item.value">
                <span style="float: left">{{ item.label }}</span>
                <span style="float: right; color: #8492a6">{{ item.value }}</span>
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="家庭地址" prop="address">
            <el-input style="width: 400px" v-model="form.address" ></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="5">
              <el-form-item label="家长姓名" prop="parent_name">
                <el-input v-model="form.parent_name" style="width: 175px"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6" :offset="1">
              <el-form-item label="联系电话" prop="parent_tele">
                <el-input v-model="form.parent_tele" style="width: 220px"></el-input>
              </el-form-item> 
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>申请信息</h4></div>
          <el-form-item label="最近14天内是否有发热、咳嗽、乏力、咽痛、腹泻等症状?" prop="symptom">
            <el-radio-group v-model="form.fever">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="最近14天内是否有接触确诊/疑似病例或无症状感染者?" prop="contact_patient">
            <el-radio-group v-model="form.contact_patient">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="最近28天内是否有国（境）外旅居史?" prop="abroad">
            <el-radio-group v-model="form.abroad">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否接触过从国（境）外返回但未满28天的人员?" prop="contact_abroad">
            <el-radio-group v-model="form.contact_abroad">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="最近14天内一同居住的人员是否有上述情况?" prop="roommate">
            <el-radio-group v-model="form.roommate">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="以上地区是否为澳门地区?" prop="macao">
            <el-radio-group v-model="form.macao">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="来校前21天内或返校过程中是否旅居或途径高风险地区?" prop="high_risk">
            <el-radio-group v-model="form.high_risk">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="来校前21天内或返校过程中是否旅居或途径中风险地区?" prop="medium_risk">
            <el-radio-group v-model="form.medium_risk">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="来校前21天内或返校过程中是否旅居或途径杭州市内封控区或管控区?" prop="control_area">
            <el-radio-group v-model="form.control_area">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="来校前14天内或返校过程中是否旅居或途径杭州市内防范区?" prop="prevent_area">
            <el-radio-group v-model="form.prevent_area">
              <el-radio label=true>是</el-radio>
              <el-radio label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="浙江省健康码登记证件号" prop="certificate">
            <el-input v-model="form.certificate" style="width: 250px" readonly="true"></el-input>
          </el-form-item>
          <el-form-item label="浙江省健康码状态" prop="health_code">
            <el-input v-model="form.health_code" style="width 150px" readonly="true"></el-input>
          </el-form-item>
          <el-form-item label="是否对健康码状态有异议" prop="health_code_objection">
            <el-radio-group v-model="form.health_code_objection">
              <el-radio label="true">是</el-radio>
              <el-radio label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item v-if="form.health_code_objection == 'true'"
            label="请上传浙江省健康码" prop="health_code_screenshot">
            <br>
            <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
              <i slot="default" class="el-icon-plus"></i>
              <div slot="file" slot-scope="{file}">
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
              </div>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </el-form-item>
          <el-form-item label="请上传14天通行数据查询截图" prop="route_screenshot">
            <br>
            <el-upload ref="route_upload" action="#" :filelist="route_list" list-type="picture-card" :limit="1" :auto-upload="false">
              <i slot="default" class="el-icon-plus"></i>
              <div slot="file" slot-scope="{file}">
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span class="el-upload-list__item-delete" @click="handleRemove('route_upload')">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
              </div>
            </el-upload>
          </el-form-item>
          <el-form-item label="14天行程卡是否有杭州外其他地区星号" prop="route_star">
            <el-radio-group v-model="form.route_star">
              <el-radio label="true">是</el-radio>
              <el-radio label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="请上传18小时核酸阴性证明截图" prop="nucleic_negative">
            <br>
            <el-upload ref="nucleic_upload" action="#" :filelist="nucleic_list" list-type="picture-card" :limit="1" :auto-upload="false">
              <i slot="default" class="el-icon-plus"></i>
              <div slot="file" slot-scope="{file}">
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span class="el-upload-list__item-delete" @click="handleRemove('nucleic_upload')">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
              </div>
            </el-upload>
          </el-form-item>
          <el-form-item label="疫苗接种情况" prop="vaccine">
            <el-select v-model="form.vaccine">
              <el-option label="未接种" value="non"></el-option>
              <el-option label="已接种第一针" value="first"></el-option>
              <el-option label="已接种第二针（未满六个月）" value="second_less_than_six_months"></el-option>
              <el-option label="已接种第二针（已满六个月）" value="second_more_than_six_months"></el-option>
              <el-option label="已接种第三针" value="third"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="请上传支付宝健康疫苗接种页截图（支付宝-健康码-新冠疫苗接种）" prop="vaccine_screenshot">
            <br>
            <el-upload ref="vaccine_upload" action="#" :filelist="vaccine_list" list-type="picture-card" :limit="1" :auto-upload="false">
              <i slot="default" class="el-icon-plus"></i>
              <div slot="file" slot-scope="{file}">
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span class="el-upload-list__item-delete" @click="handleRemove('vaccine_upload')">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
              </div>
            </el-upload>
          </el-form-item>
          <el-row>
            <el-col span="12">
              <el-form-item label="备注">
                <el-input v-model="form.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}" style="width: 500px"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>来校信息</h4></div>
          <el-form-item label="当前所在地" prop="location">
            <el-cascader :options="locations" v-model="form.location" @change="handleChange"></el-cascader>
          </el-form-item>
          <el-form-item label="到校日期" prop="return_date">
            <el-date-picker type="date" v-model="form.return_date" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item label="预计到校时段" prop="return_period">
            <el-select type="date" v-model="form.return_period" placeholder="请选择时段">
              <el-option label="上午" value="morning"></el-option>
              <el-option label="下午" value="afternoon"></el-option>
              <el-option label="晚上" value="evening"></el-option>
              <el-option label="凌晨" value="dawn"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="交通工具" prop="vehicle_kind">
            <el-row>
              <el-col span="5">
                <el-select v-model="form.vehicle_kind">
                  <el-option label="飞机" value="plane"></el-option>
                  <el-option label="火车" value="train"></el-option>
                  <el-option label="长途汽车" value="coach"></el-option>
                  <el-option label="自驾" value="self_driving"></el-option>
                  <el-option label="其他" value="others"></el-option>
                </el-select>
              </el-col>
              <el-col span="6">
                <el-input v-if="form.vehicle_kind == 'others'" v-model="form.vehicle" prop="vehicle"></el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item v-if="form.vehicle_kind == 'plane' || form.vehicle_kind == 'train' || form.vehicle_kind == 'coach'"
            label="预计到站日期" prop="arrive_date">
            <el-date-picker type="date" v-model="form.arrive_date" placeholder="请选择日期"></el-date-picker>
          </el-form-item>
          <el-form-item v-if="form.vehicle_kind == 'plane' || form.vehicle_kind == 'train' || form.vehicle_kind == 'coach'"
            label="预计到站时间" prop="arrive_time">
            <el-time-select  v-model="form.arrive_time" placeholder="请选择时间"
              :picker-options="{start: '0:00', end: '24:00', step: '0:10'}"></el-time-select>
          </el-form-item>
          <el-form-item v-if="form.vehicle_kind == 'plane' || form.vehicle_kind == 'train' || form.vehicle_kind == 'coach'"
            label="航班车次" prop="transport_num">
            <el-input v-model="form.transport_num" style="width: 400px"></el-input>
          </el-form-item>
          <el-form-item v-if="form.vehicle_kind == 'plane' || form.vehicle_kind == 'train' || form.vehicle_kind == 'coach'"
            label="到达车站/机场" prop="arrive_port">
            <el-select v-model="form.arrive_port">
              <el-option label="城站火车站" value="train_station"></el-option>
              <el-option label="杭州东站" value="Hangzhou_East"></el-option>
              <el-option label="萧山机场" value="Xiaoshan_airport"></el-option>
              <el-option label="汽车客运站" value="bus_station"></el-option>
              <el-option label="其他" value="others"></el-option>
            </el-select>
          </el-form-item>
          <el-divider></el-divider>
          <div style="display: flex;"><h4>个人承诺</h4></div>
          <el-form-item prop="promise">
            <el-checkbox v-model="form.promise" label="true">
              本人承诺：以上情况信息属实。如有相关变化，将及时报告院系。到校途中严格做好个人防护；到校后服从疫情防控要求，做好个人健康管理，如实报告相关信息。
              <br>
              来校前14天内未到过（含途径）中高风险地区所在县（市、区）及要求全域管控区域，本人及共同居住家庭成员返校前14天未有发热、干咳、咽痛、流涕、腹泻、
              <br>
              乏力、嗅（味）觉减退、肌肉酸痛等症状。如有瞒报，本人愿意承担由此引起的责任
            </el-checkbox>
          </el-form-item>
          <div class="submit-btn">
            <el-form-item>
              <el-button type="primary" @click="submitForm('StuPassphraseApplication')">提交表单</el-button>
            </el-form-item>
          </div>
        </el-form>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
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
        stu_id: '3190103176',
        date: Date.now(),
        location:[],
        certificate: '330903197805145114',
        health_code: '绿码'
      },
      locations:regionData,
      counsellors: [{
        value: '0000001',
        label: '辅导员A'
      },{
        value: '0000002',
        label: '辅导员B'
      }],
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
      route_list: [],
      nucleic_list: [],
      vaccine_list: [],
      dialogImageUrl: '',
      dialogVisible: false,
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
        location: [
          { required: true, validator:validCascader, trigger: "change" }
        ],
        return_date: [
          { required: true, message: "请选择日期", trigger: "change" }
        ],
        return_period: [
          { required: true, message: "请选择时段", trigger: "change" }
        ],
        vehicle_kind: [
          { required: true, message: "请选择交通工具种类", trigger: "change"}
        ],
        vehicle: [
          { required: true, message: "该栏不能为空", trigger: "blur"}
        ],
        transport_num: [
          { required: true, validator:vlidator_transport_num, trigger: "blur" }
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
    goOff(){
      this.$router.go(-1);
    },
    handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
    },
    handleRemove(ref_name) {
      this.$refs[ref_name].clearFiles();
    },
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