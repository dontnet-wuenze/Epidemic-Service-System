<template>
  <el-container style="min-width: 1200px; height: 1140px">
    <el-header>
      <el-row style="margin-bottom: 20px;">
        <!-- el-col :span="1" :offset="1" style="height: 60px">
          <div class="center">
            <img src="/favicon.ico" height="50" width="50">
          </div>
        </el-col>
        <el-col :span="5" class="header-head">浙江大学疫情服务与管理系统</el-col-->
        <el-col :span="7" :offset="1" style="height: 60px; display: flex; justify-content: flex-end">
          <div class="title-box">
            <div class="center">
              <img src="/favicon.ico" height="50" width="50">
            </div>
            <div class="header-head">
              <span class="rainbow-font">浙江大学疫情服务与管理系统</span>
            </div>
          </div>
        </el-col>
        <el-col :span="0.01" style="color: #fff">|</el-col>
        <el-col :span="1">
          <div class="header-box" @click="change('/index')">
            <p class="header-font" style="cursor: pointer">主页</p>
          </div>
        </el-col>
        <el-col :span="1" >
          <div class="header-box" @click="change('/health/attend')">
            <p class="header-font" style="cursor: pointer">打卡</p>
          </div>
        </el-col>
        <el-col :span="8" :offset="5">
          <div v-show="!isLogin" class="header-box" @click="change('/login')">
            <p class="header-font" style="cursor: pointer">登录</p>
          </div>
          <div v-show="isLogin" class="user-box" >
            <el-row class="sub-row" type="flex" justify="center">
              <el-col :span="3">
                <el-dropdown style="width: 100%;" @command="handleNoticeMenu">
                  <div class="notice-box" style="cursor: pointer">
                    <div style="display: flex; justify-content: center; align-items: center">
                      <el-badge class="notice" :value="10">
                        <i class="el-icon-bell" style="font-size: 20px; color: white"></i>
                      </el-badge>
                    </div>
                  </div>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="systemNotice">系统通知</el-dropdown-item>
                    <el-dropdown-item command="applyRecord">申请记录</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </el-col>
              <el-col :span="8">
                <el-dropdown style="width: 100%" @command="handleUserMenu">
                  <div class="user-info-box" style="cursor: pointer">
                      <div class="user-img">
                        <el-avatar size="large" src="/favicon.ico"></el-avatar>
                      </div>
                      <div class="header-font">{{this.$store.state.username}}</div>
                  </div>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="showinfo">个人信息</el-dropdown-item>
                    <el-dropdown-item command="logout">注销</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </el-col>
            </el-row>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <div class="blue-bg">
      <div class="banner">
        <img src="/img/health/text.png">
      </div>
      <div class="content-box">
        <keep-alive>
         <router-view></router-view>
        </keep-alive>
      </div>
    </div>
    <div class="footer-box">
      <div class="footer-top">
        <div class="footer-main">
          <h3>链接</h3>
        </div>
        <div class="footer-main">
          <h3>关于我们</h3>
        </div>
        <div class="footer-social">
          <p class="footer-social-title">ZJU EMS 2.0</p>
          <div class="footer-social-box">
            <a class="icon-box" href="https://github.com/dontnet-wuenze/Epidemic-Service-System" target="_blank">
              <img class="elementdoc" src="/icon/github-fill.png">
            </a>
            <a class="icon-box" href="https://cn.vuejs.org" target="_blank">
              <img class="elementdoc" src="/icon/vue.png">
            </a>
            <a class="icon-box" href="https://element.eleme.io" target="_blank">
              <img class="elementdoc" src="/icon/Element.png">
            </a>
          </div>
        </div>
      </div>
      <div class="footer-bottom">
        <div>版权所有:浙江大学软件工程小组</div>
      </div>
    </div>
    <el-drawer
        title="系统消息"
        :size="600"
        :visible.sync="drawer"
        :direction="direction"
        :before-close="handleClose">
      <div class="drawer-container">
        <div class="drawer-button">
          <button class="notice-button">全部标为已读</button>
        </div>
        <div class="drawer-notice">
          <div class="notice-container" v-for="notice in currentNotice" :key="notice.date">
            <div class="notice-container-top">
              <div class="notice-container-date">{{notice.date}}</div>
              <div class="notice-container-title">{{notice.title}}</div>
            </div>
            <div class="notice-container-bottom">
              {{notice.detail}}
            </div>
          </div>
        </div>
        <div class="splitPage">
          <el-pagination
              background
              layout="prev, pager, next, jumper"
              @current-change="handlePageChange"
              :page-size="8"
              :total="noticeList.length">
          </el-pagination>
        </div>
      </div>
    </el-drawer>
  </el-container>

</template>

<script>
//import HelloWorld from "@/components/HelloWorld";
import {sendNotice} from "@/api/statistic";

export default {
  name: 'Header',
  data() {
    return {
      drawer: false,
      direction: 'rtl',
      isLogin: !!localStorage.getItem('token'),
      currentNotice: [],
      noticeList: [
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        },
        {
          title: '今日未打卡',
          date: '2022-05-16 09:57:16',
          detail: '请及时打卡，当日未打卡取消健康码!'
        }
      ]
    }
  },
  watch: {
    '$route' (to, from) {
      //this.$router.go(0);
      console.log('router has change')
      console.log(localStorage.getItem('token'))
      this.isLogin = !!localStorage.getItem('token');
    }
  },
  methods: {
    change (path) {
      this.$router.push(path)
    },
    handleUserMenu(command) {
      if (command === 'logout') {
        localStorage.removeItem('token');
        localStorage.removeItem('state');
        console.log(this.$route.path)
        if(this.$route.path != '/index')
          this.$router.push('/index');
        this.isLogin = !!localStorage.getItem('token');
      } else if(command === 'showinfo') {
        this.$router.push('/myspace/showinfo')
      }
    },
    handleNoticeMenu(command) {
      if(command==='systemNotice') {
        this.drawer=true
      } else if(command==='applyRecord') {
        this.$router.push('/approval/Application_Log')
      }
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
    },
    handlePageChange(currentindex){
      //contentdata是所有的数据，是一个大数组。使用.slice()方法可以将大数组切分
      //.slice()方法接受两个参数，开始和结束的值
      //这样得到的currentdata就是固定只有10个值的数组了，就可以用v-for展示啦
      this.currentNotice = this.noticeList.slice((currentindex-1)*8, currentindex*8)
      console.log(currentindex);
    }
  },
  components: {
    //HelloWorld
  },
  mounted() {
    this.currentNotice = this.noticeList.slice(0, 8)
  }
}
</script>

<style>
.rainbow-font {
  background: linear-gradient(to right, red, orange, yellow, green, cyan, purple);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  animation:  hue 1s linear infinite;
}
@keyframes hue {
  0% {
    filter: hue-rotate(0deg);
  }
  100% {
    filter: hue-rotate(360deg);
  }
}

.blue-bg{
  background: url('../../../public/img/health/blue-bg.png') no-repeat left top;
  background-size: 100% auto;
  width:100%;
  height: 1080px;
}

.center {
  width: 20px;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.banner {
  width: 100%;
  text-align: center;
  margin: 40px 0;
}

.title-box {
  width: 400px;
  height: 60px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.content-box {
  width: 90%;
  height: 750px;
  border-radius: 10px;
  box-shadow: 0 0 8px rgb(0 0 0 / 40%);
  background: white;
  margin: 0 auto;
  position: relative;
}

.notice-box{
  width: 100%;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.notice {
  width:30px;
  height: 30px;
  background: gray;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
}


.header-box{
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.user-box{
  width: 100%;
  height: 60px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.user-info-box{
  width: 100%;
  height: 60px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

.header-head{
  color: #fff;
  font-size: 1.3rem;
  font-family: KaiTi;
  width: 80%;
}

.header-font{
  color: #fff;
  font-size: 1rem;
  font-family: 微软雅黑;
}

.sub-row{
  height: 100%;
  width: 100%;
}

.user-img{
  display: flex;
  justify-content: center;
  align-items: center;
}

.el-row {
  width: 100%;
}
.el-col {
  border-radius: 4px;
}

.el-header {
  background-color: rgba(81,153,216,.8);
  color: #333;
  text-align: center;
  line-height: 60px;
  width: 100%;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background: url('../../../public/img/health/blue-bg.png') no-repeat left top;
  background-size: 100% auto;
  width:100%;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

::v-deep .el-footer {
  height: 100px;
}

.footer-box {
  background-color: #f7fbfd;
  width: 100%;
  padding: 40px 200px;
  box-sizing: border-box;
  height: 340px;
}

.footer-top{
  height: 260px;
  margin: 0 auto;
}

.footer-main{
  height: 260px;
  width: 100px;
  display: inline-block;
  vertical-align: top;
  margin-right: 50px;
}

.footer-social {
  float: right;
  text-align: right;
}

.footer-social-title {
  color: #666;
  font-size: 18px;
  line-height: 1;
  margin: 0 10px 20px 0px;
  padding: 0;
  font-weight: 700;
}

.footer-social-box {
  display: flex;
  justify-content: flex-end;
}

.footer-bottom {
  width: 100%;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.icon-box {
  width: 40px;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.elementdoc {
  transition: .3s;
  display: inline-block;
  line-height: 32px;
  text-align: center;
  color: #c8d6e8;
  background-color: transparent;
  size: 32px;
  font-size: 32px;
  vertical-align: middle;
  height: 30px;
  width: 30px;
}

.elementdoc:hover {
  color: #409EFF;
  height: 40px;
  width: 40px;
}

.drawer-container {

}

.drawer-button {
  height: 30px;
}

.notice-button {
  width: 100px;
  height: 30px;
  background-color: #5198d8;
  color: #fcfcfc;
  border: 0px;
  border-radius: 3px;
  font-size: 12px;
  text-align: center;
  margin-left: 15px;
}

.notice-button:hover {
  filter: brightness(1.2);
}

.drawer-notice {
  margin-top: 20px;
  height: 730px;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}

.notice-container {
  height: 90px;
  width: 100%;
  border-bottom: 1px dashed #d3d3d3;
  display: flex;
  flex-direction: column;
}

.notice-container-top {
  padding-left: 20px;
  height: 30px;
  display: flex;
  flex-direction: column;
}

.notice-container-date {
  height: 20px;
  font-size: 12px;
  color: gray;
}

.notice-container-title {
  height: 20px;
  margin-top: 10px;
}

.notice-container-bottom {
  padding-left: 30px;
  margin-top: 35px;
  height: 50px;
}

.splitPage {
  padding-right: 20px;
  display: flex;
  flex-direction: row-reverse;
}

</style>

<style lang="scss" scoped>
::v-deep .el-drawer {
  .el-drawer__header {
    margin-bottom: 20px;
  }
}
</style>
