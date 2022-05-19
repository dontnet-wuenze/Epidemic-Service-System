<template>
    <el-scrollbar class="customScrollbar">
      <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
      </div>
      <div class="container">
      <div class="scroll-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>每日健康打卡</h3></div>
      </div>
      <div class="scroll-container-form">
        <el-form ref="dailyForm" :label-position="labelPosition" :model="form" label-width="80px" :rules="rules">
          <el-row :gutter="20">
            <el-col :span="6">
              <el-form-item label="今日日期  Date">
                <el-date-picker
                    v-model="form.date"
                    type="date"
                    placeholder="选择日期"
                    :readonly="true" >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="4" :offset="2">
              <el-form-item label="姓名 Name">
                <el-input v-model="form.name" :readonly="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7" :offset="2">
              <el-form-item label="学工号 Student/Staff ID No.">
                <el-input v-model="form.id" :readonly="true"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="所在校区 Campus" prop="campus">
                <el-select v-model="form.campus" placeholder="请选择校区">
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
            <el-col :span="8" :offset="2">
              <el-form-item label="所在地点 Location" prop="region">
                <el-cascader
                    :options="options"
                    v-model="selected_region"
                    @change="handleChange"
                >
                </el-cascader>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="今日是否在校? Are you on campus today?" prop="onCampus">
            <el-radio-group v-model="form.onCampus">
              <el-radio :label=true> 是 Yes</el-radio>
              <el-radio :label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日健康码状态? What's the color of your health code today?" prop="codeStatus">
            <el-radio-group v-model="form.codeStatus">
              <el-radio :label="0">绿码 Green code</el-radio>
              <el-radio :label="1">红码 Red code</el-radio>
              <el-radio :label="2">黄码 Yellow code</el-radio>
              <el-radio :label="3">橙码 Orange code</el-radio>
              <el-radio :label="4">无 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日是否有发热症状(高于37.2℃) Do you have a fever(above 37.2℃) today?" prop="fever">
            <el-radio-group v-model="form.fever">
              <el-radio :label=true> 是 Yes</el-radio>
              <el-radio :label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日是否有涉及疫情的管控措施 Are you under any control measures related to the COVID-19 today?"
            prop="control">
            <el-radio-group v-model="form.control">
              <el-radio :label=true> 是 Yes</el-radio>
              <el-radio :label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否与新冠确诊人员或密接人员接触 Have you been in close contact with confirmed cases or
          close contact cases?" prop="contact">
            <el-radio-group v-model="form.contact">
              <el-radio :label=true> 是 Yes</el-radio>
              <el-radio :label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-row :gutter="20" style="margin-bottom: 22px">
            <el-col :span="4">
                <el-input v-model=inputCode placeholder="请输入验证码"></el-input>
            </el-col>
            <el-col :span="4">
              <div @click="changeCode()">
                <!-- 引入验证码组件 -->
                <identify :identifyCode="identifyCode"></identify>
              </div>
            </el-col>
          </el-row>
          <el-form-item prop="verify">
            <el-radio v-model="form.varify" :label="true">
              <br>
              本人承诺：
              <br>
              上述信息真实准确。如有变化，及时更新相关信息并报告所在单位。
              <br>
              本人已知晓并将遵守政府和学校相关规定，配合做好疫情防控工作。
              <br>
              I certify:
              <br>
              The above information is true and accurate. In case of changes,
              <br>
              I will keep my information updated and report in a timely manner.
              <br>
              I have understood and will abide by the relevant government and
              <br>
              University regulations to facilitate the prevention and control of COVID-19 epidemic.
            </el-radio>
          </el-form-item>
          <div class="submit-btn">
            <div v-show="status===false">
              <el-form-item>
                <el-button type="primary" @click="submitForm('dailyForm')">提交表单</el-button>
              </el-form-item>
            </div>
            <div v-show="status===true">
              <el-form-item>
                <el-button type="info" disabled>今日已打卡</el-button>
              </el-form-item>
            </div>
          </div>
        </el-form>
      </div>
      </div>
    </el-scrollbar>

</template>

<script>
import { regionData, CodeToText , TextToCode } from "element-china-area-data";
import identify from '../../components/identify.vue'
import {userAttendGet, userAttendSubmit} from "@/api/user";
import router from "@/router";
const dayjs = require('dayjs');

function regionConvert(region) {
  var regionList = region.split(',')
  var List = []
  List[0] = TextToCode[regionList[0]].code;
  List[1] = TextToCode[regionList[0]][regionList[1]].code;
  List[2] = TextToCode[regionList[0]][regionList[1]][regionList[2]].code;
  return List;
}

export default {
  name: "attend",
  data() {
    let validCascader = (rule, value, callback) => {
      if (this.selected_region.length === 0) {
        callback(new Error('请选择所在地区'));
      } else {
        callback();
      }
    }
    return {
      status: 'false',
      labelPosition: "top",
      options: regionData,
      region: [],
      selected_region: [],
      inputCode: "",
      // 验证码初始值
      identifyCode: '1234',
      // 验证码的随机取值范围
      identifyCodes: '1234567890',
      form: {
        name: '吴恩泽',
        date: '2022-5-12',
        id: '3190102297',
        campus: '',
        onCampus: true,
        codeStatus: 0,
        fever: true,
        control: true,
        contact: true,
        varify: true
      },

      rules: {
        campus: [
          { required: true, message: "请选择校区", trigger: "change" }
        ],
        region: [
          { required: true, validator:validCascader, message: "请选择地区", trigger: "change" }
        ],
        onCampus: [
          { required: true, message: "请选择是否在校", trigger: 'change'}
        ],
        codeStatus: [
          { required: true, message: "请选择健康码状态", trigger: 'change'}
        ],
        fever: [
          { required: true, message: "请选择是否有发热症状", trigger: 'change'}
        ],
        control: [
          { required: true, message: "请选择是否有涉及疫情的管控措施", trigger: 'change'}
        ],
        contact: [
          { required: true, message: "请选择是否与新冠确诊人员或密接人员接触", trigger: 'change'}
        ],
        code: [
          { required: true, message: "请输入验证码", trigger: 'change'}
        ]
      }
    }
  },
  async mounted() {
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
    let _this = this; // 声明一个变量指向Vue实例this，保证作用域一致
    userAttendGet().then(res => {
      console.log(res);
      _this.form.name = res.data.name;
      _this.form.id = res.data.id;
      _this.form.date = dayjs().format('YYYY-MM-DD');
      _this.form.varify = true;
      _this.status = res.data.status;
      if(res.data.status) {
        _this.form.campus = res.data.campus;
        _this.form.onCampus = res.data.onCampus;
        _this.form.codeStatus = res.data.codeStatus;
        _this.form.fever = res.data.fever;
        _this.form.control = res.data.control;
        _this.form.contact = res.data.contact;
        _this.selected_region = regionConvert(res.data.region);
      }
    }).catch(error=> {
      console.log(error);
    })
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.inputCode == this.identifyCode) {
            var submit_data = {
              id: this.form.id,
              name: this.form.name,
              date: this.form.date,
              campus: this.form.campus,
              region: this.region,
              onCampus: this.form.onCampus,
              codeStatus: this.form.codeStatus,
              fever: this.form.fever,
              control: this.form.control,
              contact: this.form.contact
            }
            userAttendSubmit(submit_data).then(res=> {
              this.$message.success('提交成功!');
              router.go(0)
            }).catch(error=>{
              this.$message.error(error)
            })
          } else {
            this.identifyCode = ''
            this.makeCode(this.identifyCodes, 4)
            this.$message.error('验证码错误')
          }
        } else {
          this.$message.error('表单填写有误，请检查后重新提交！');
          return false;
        }
      });
    },

    goOff(){
      this.$router.go(-1);
    },

    handleChange(value) {
      if (value[1] != null && value[2] != null) {
        var dz = CodeToText[value[0]] + ',' + CodeToText[value[1]] + ',' + CodeToText[value[2]]
      } else {
        if (value[1] != null) {
          dz = CodeToText[value[0]] + ',' + CodeToText[value[1]]
        } else {
          dz = CodeToText[value[0]]
        }
      }
      this.region = dz
      console.log(this.region)
      console.log(this.selected_region)
    },

    // 点击验证码刷新验证码
    changeCode () {
      this.identifyCode = ''
      this.makeCode(this.identifyCodes, 4)
    },
    // 生成一个随机整数  randomNum(0, 10) 0 到 10 的随机整数， 包含 0 和 10
    randomNum (min, max) {
      max = max + 1
      return Math.floor(Math.random() * (max - min) + min)
    },
    // 随机生成验证码字符串
    makeCode (data, len) {
      for (let i = 0; i < len; i++) {
        this.identifyCode += data[this.randomNum(0, data.length - 1)]
      }
    },
  },
  components: {
    identify
  }
}
</script>

<style scoped>

.container{
  position: relative;
  z-index: 1;
  height: 100%;
  margin: 10px auto;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

.scroll-container-title{
  height: 100px;
  margin: 20px auto;
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}

.scroll-container-form {
  width: 100%;
}

.submit-btn{
  margin-top: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}

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
</style>
