<template>
  <div class="login-section">
    <!-- :rules="rules" -->
    <el-form 
      label-position="top" label-width="100px" class="demo-ruleForm"
       :rules="rules"
      :model="rulesForm"
      status-icon
      ref="ruleForm"
    >
      <el-form-item label="用户名" prop="name">
        <el-input type="text" v-model="rulesForm.name"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="rulesForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"  @click="submitForm('ruleForm')">提交</el-button>
        <el-button>重置</el-button>
      </el-form-item>
    </el-form>
  </div>
 
 
 
 
</template>
<script>

import { userLogin } from '@/api/user';

export default {
  data() {
     return {
      //存储数据的对象
      rulesForm:{
        name:'',
        password:''
      },
      rules:{
        name:[
          {required:true,message:'名字',trigger:'blur'},
          {min:1,max:5,message:'长度在3到5',trigger:'blur'}
        ],
        password:[
          {required:true,message:'密码',trigger:'blur'},
          {min:3,max:5,message:'长度在3到5',trigger:'blur'}
        ]
      }
    };
  },
  methods: {
submitForm(formName){
      this.$refs[formName].validate( (valid) =>{
        if(valid){
          var user_data = {
            id: this.$refs[formName].name,
            password: this.$refs[formName].password
          }
          //如果校检通过，在这里向后端发送用户名和密码
          this.$store.dispatch('login', this.rulesForm.name).then(() => {
            // 登陆成功之后，路由跳转至用户账户页或者进行你需要的操作
            this.$router.push({
              path: '/index',
            })
          });
        }else{
          console.log('error submit!!');
          return false
        }
      });
    }
  }
}
</script>
 
 
 
 
 
 
 
 
<style lang="scss">
.login-section{
  padding: 0px 20px;
}
</style>