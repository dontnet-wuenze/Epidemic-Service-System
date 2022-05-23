<template>
  <div class="people-list-container">
    <div class="people-list-title">
      <h2>本科生未核酸检测人员列表</h2>
    </div>
    <div class="display">
      <el-table
          ref="multipleTable"
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
          height="500"

          tooltip-effect="dark"
          stripe
          @selection-change="handleSelectionChange"
          style="width: 100%">
        <el-table-column
            type="selection"
            width="44">
        </el-table-column>
        <el-table-column
            prop="id"
            label="学号"
            width="110">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="90">
        </el-table-column>
        <el-table-column
            prop="department"
            label="学院"
            sortable
            width="200">
        </el-table-column>
        <el-table-column
            prop="major"
            label="专业"
            :filters="[{text: '计算机科学与技术', value:'计算机科学与技术'}, {text:'软件工程', value: '软件工程'},
                        {text:'信息安全', value: '信息安全'}]"
            :filter-method="filterMajor"
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
            width="">
        </el-table-column>
        <el-table-column
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
                @click="handleDelete(scope.$index, scope.row)">发送通知</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px">
        <el-button @click="sendMessege()" type="danger">发送通知</el-button>
        <el-button @click="toggleSelection()" type="primary">取消选择</el-button>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "peopleList",
  data() {
    return {
      multipleSelection: [],
      search: '',
      tableData: [{
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      }, {
        id: '3190102222',
        name: '王小虎',
        department: '计算机科学与技术学院',
        major: '计算机科学与技术',
        class: '计科1901',
        phone: '13888888888'
      },
      ]
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
    filterMajor(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    }
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
