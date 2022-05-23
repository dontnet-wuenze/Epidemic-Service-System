<template>
  <div class="statistic-container">
    <el-row>
      <el-col :span="5">
        <h3>统计数据</h3>
        <el-menu
            :default-active="activeIndex"
            @select="handleSelect"
            class="el-menu-vertical"
            @open="handleOpen"
            @close="handleClose">
          <el-menu-item index="peopleNumber">
            <i class="el-icon-s-data"></i>
            <span slot="title">人数统计</span>
          </el-menu-item>
          <el-menu-item index="campus">
            <i class="el-icon-position"></i>
            <span slot="title">校区统计</span>
          </el-menu-item>
          <el-menu-item index="peopleList">
            <i class="el-icon-user"></i>
            <span slot="title">未打卡人员</span>
          </el-menu-item>
        </el-menu>
      </el-col>
      <el-col :span="19">
        <keep-alive>
          <component :is="activeIndex"></component>
        </keep-alive>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import peopleNumber from "@/components/statistic/peopleNumber";
import campus from "@/components/statistic/campus";
import peopleList from "@/components/statistic/peopleList";


export default {
  name: "statistic",
  data () {
    return {
      activeIndex: "peopleNumber",
      openNames: ['1']
    }
  },
  methods: {
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
    peopleNumber,
    campus,
    peopleList
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

</style>
