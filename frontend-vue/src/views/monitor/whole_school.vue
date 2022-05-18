<template>
  <div class="statistic-container">
    <el-row>
      <el-col :span="4">
        <h3>全校核酸统计</h3>
        <el-menu
            :default-active="activeIndex"
            @select="handleSelect"
            class="el-menu-vertical"
            @open="handleOpen"
            @close="handleClose">
          <el-menu-item index="p_number">
            <i class="el-icon-s-data"></i>
            <span slot="title">人数统计</span>
          </el-menu-item>
          <el-menu-item index="campus_statistic">
            <i class="el-icon-position"></i>
            <span slot="title">校区统计</span>
          </el-menu-item>
          <el-menu-item index="no_check_list">
            <i class="el-icon-user"></i>
            <span slot="title">未核酸检测人员</span>
          </el-menu-item>
        </el-menu>
      </el-col>
      <el-col :span="20">
        <keep-alive>
          <component :is="activeIndex"></component>
        </keep-alive>
      </el-col>
    </el-row>
    <button @click="goOff()" style="margin-left:85%; margin-bottom: 10%;" class="button">返回</button>
  </div>
</template>

<script>

import p_number from "@/components/monitor_statistic/p_number";
import campus_statistic from "@/components/monitor_statistic/campus_statistic";
import no_check_list from "@/components/monitor_statistic/no_check_list";


export default {
  name: "statistic",
  data () {
    return {
      activeIndex: "p_number",
      openNames: ['1']
    }
  },
  methods: {
    goOff(){
            this.$router.go(-1);
        },
    handleSelect (index) {
      this.activeIndex = index;
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath);
    }
  },
  components: {
    p_number,
    campus_statistic,
    no_check_list
  },
}
</script>

<style scoped>
.statistic-container {
  height: 100%;
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
}

.statistic-aside {
  width: 200px;
}

.el-menu-vertical:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.button {
    position: relative;
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
