<template>
  <div class="login-section">
    <!-- :rules="rules" -->
    <el-form
      label-position="left" label-width="100px" class="login-form"
       :rules="rules"
      :model="rulesForm"
      status-icon
      ref="ruleForm"
    >
      <el-form-item label="学号" prop="id">
        <el-input type="text" v-model="rulesForm.id"></el-input>
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
        id:'',
        password:''
      },
      rules:{
        id:[
          {required:true,message:'学号',trigger:'blur'},
          {min:1,max:10,message:'长度在1到10',trigger:'blur'}
        ],
        password:[
          {required:true,message:'密码',trigger:'blur'},
          {min:4,message:'长度大于4',trigger:'blur'}
        ]
      }
    };
  },
  methods: {
submitForm(formName){
      this.$refs[formName].validate( (valid) =>{
        if(valid){
          var user_data = {
            id: this.$refs[formName].id,
            password: this.$refs[formName].password
          }
          //如果校检通过，在这里向后端发送用户名和密码
          this.$store.dispatch('login', user_data).then(() => {
            // 登陆成功之后，路由跳转至用户账户页或者进行你需要的操作
            this.$router.push({
              path: '/index',
            })
          });
        }else{
          console.log('登录失败!!');
          return false
        }
      });
    }
  }
}
</script>








<style lang="scss">
.login-section{
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}

.login-form {
  padding-top: 100px;
  width: 300px;
  height: 300px;
}

</style>
