<template>
  <div class="people-list-container">
    <div class="people-list-title">
      <h2>未打卡人员列表</h2>
    </div>
    <div class="display">
      <el-table
          ref="multipleTable"
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          height="500"
          tooltip-effect="dark"
          stripe
          @selection-change="handleSelectionChange"
          v-loading="loading"
          style="width: 1050px"
          >
        <el-table-column
            type="selection"
            fixed
            width="44">
        </el-table-column>
        <el-table-column
            prop="id"
            label="学号"
            fixed
            width="110">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            fixed
            width="90">
        </el-table-column>
        <el-table-column
            prop="grade"
            label="年级"
            :filters="departmentList"
            :filter-method="filterCol"
            width="90">
        </el-table-column>
        <el-table-column
            prop="department"
            label="学院"
            :filters="departmentList"
            :filter-method="filterCol"
            sortable
            width="200">
        </el-table-column>
        <el-table-column
            prop="major"
            label="专业"
            :filters="majorList"
            :filter-method="filterCol"
            sortable
            width="200">
        </el-table-column>
        <el-table-column
            prop="class"
            label="班级"
            sortable
            width="120">
        </el-table-column>
        <el-table-column
            prop="phone"
            label="手机号"
            width="120">
        </el-table-column>
        <el-table-column
            width="150"
            align="center">
          <template slot="header">
            <el-input
                v-model="search"
                size="mini"
                placeholder="输入姓名搜索"/>
          </template>
          <template v-slot="scope">
            <el-button
                size="mini"
                type="danger"
                @click="sendSingleNotice(scope.$index, scope.row)">发送通知</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px">
        <el-button @click="sendMultiNotice()" type="danger">发送通知</el-button>
        <el-button @click="toggleSelection()" type="primary">取消选择</el-button>

      </div>
    </div>
  </div>
</template>

<script>
import departmentJSON from './department.json'
let departmentList = departmentJSON.departmentList

import majorJSON from './major.json'
let majorList = majorJSON.majorList

import {unattendList, sendNotice } from "@/api/statistic";

export default {
  name: "peopleList",
  data() {
    return {
      loading: true,
      departmentList: departmentList,
      majorList: majorList,
      multipleSelection: [],
      search: '',
      tableData: []
    }
  },
  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    filterCol(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    sendSingleNotice(index, row) {
      var noticeList = [];
      noticeList.push(row.id);
      var send_data = {
        noticeList: noticeList
      }
      sendNotice(send_data).then(res=>{
        console.log(res)
        this.$message.success('发送通知成功')
      })
    },
    sendMultiNotice() {
      this.$confirm('是否向所有选中的人发送消息?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        var noticeList = [];
        this.multipleSelection.forEach(value => {
          noticeList.push(value.id)
        })
        var send_data = {
          noticeList: noticeList
        }
        sendNotice(send_data).then(res=>{
          console.log(res)
          this.$message.success('发送通知成功')
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消'
        });
      });
    }
  },
  async mounted() {
    this.loading = true
    unattendList().then(res=> {
      this.tableData = res.data.unattendList;
      this.loading = false;
    })
  }
}
</script>

<style scoped>
.people-list-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.people-list-title {
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid #e5e5e5;
}

.display{
  width: 100%;
  margin-top: 20px;
}
</style>
