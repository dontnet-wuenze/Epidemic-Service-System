<template>
    <el-scrollbar class="customScrollbar">
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
                    readonly="true" >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="4" offset="2">
              <el-form-item label="姓名 Name">
                <el-input v-model="form.name" readonly="true"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7" offset="2">
              <el-form-item label="学工号 Student/Staff ID No.">
                <el-input v-model="form.id" readonly="true"></el-input>
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
            <el-col :span="8" offset="2">
              <el-form-item label="所在地点 Location" prop="region">
                <el-cascader
                    :options="options"
                    v-model="region"
                    @change="handleChange"
                >
                </el-cascader>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="今日是否在校? Are you on campus today?" prop="onCampus">
            <el-radio-group v-model="form.onCampus">
              <el-radio label=true> 是 Yes</el-radio>
              <el-radio label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日健康码状态? What's the color of your health code today?" prop="codeStatus">
            <el-radio-group v-model="form.codeStatus">
              <el-radio label="0">绿码 Green code</el-radio>
              <el-radio label="1">红码 Red code</el-radio>
              <el-radio label="2">黄码 Yellow code</el-radio>
              <el-radio label="3">橙码 Orange code</el-radio>
              <el-radio label="4">无 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日是否有发热症状(高于37.2℃) Do you have a fever(above 37.2℃) today?" prop="fever">
            <el-radio-group v-model="form.fever">
              <el-radio label=true> 是 Yes</el-radio>
              <el-radio label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="今日是否有涉及疫情的管控措施 Are you under any control measures related to the COVID-19 today?"
            prop="control">
            <el-radio-group v-model="form.control">
              <el-radio label=true> 是 Yes</el-radio>
              <el-radio label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否与新冠确诊人员或密接人员接触 Have you been in close contact with confirmed cases or
          close contact cases?" prop="contact">
            <el-radio-group v-model="form.contact">
              <el-radio label=true> 是 Yes</el-radio>
              <el-radio label=false>否 No</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-row :gutter="20">
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
            <el-radio v-model="form.varify" label="true">
              <br>
              本人承诺：
              <br>
              上述信息真实准确。如有变化，及时更新相关信息并报告所在单位。
              <br>
              本人已知晓并将遵守政府和学校相关规定，配合做好疫情防控工作。
              <br>
              I certify:
              <br>
              The above information is true and accurate. In case of changes, I will keep my information updated and report in a timely manner.
              <br>
              I have understood and will abide by the relevant government and University regulations to facilitate the prevention and control of COVID-19 epidemic.
            </el-radio>
          </el-form-item>
          <div class="submit-btn">
            <el-form-item>
              <el-button type="primary" @click="submitForm('dailyForm')">提交表单</el-button>
            </el-form-item>
          </div>
        </el-form>
      </div>
      </div>
    </el-scrollbar>

</template>

<script>
import { regionData } from "element-china-area-data";
import identify from '../../components/identify.vue'

export default {
  name: "attend",
  data() {
    let validCascader = (rule, value, callback) => {
      if (this.region.length === 0) {
        callback(new Error('请选择所在地区'));
      } else {
        callback();
      }
    }
    return {
      labelPosition: "top",
      options: regionData,
      region: [],
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
        onCampus: 'true',
        codeStatus: '0',
        fever: 'true',
        control: 'true',
        contact: 'true',
        varify: 'true'
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
  mounted() {
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.inputCode == this.identifyCode) {
            this.$message.success('提交成功!');
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
