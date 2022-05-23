<template>
  <div>
    <div class="people-list-title">
      <h2>已注册人员列表</h2>
    </div>
    <el-card>
      <!-- 搜索 添加 -->
      <el-row :gutter="20">
        <el-col :span="6">
          <el-input placeholder="请输入内容"
                    v-model="queryInfo.query"
                    clearable
                    @clear="getUserList">
            <el-button slot="append"
                       icon="el-icon-search"
                       @click="getUserList"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary"
                     @click="addDialogVisible = true">添加用户</el-button>
        </el-col>
      </el-row>
      <!-- 用户列表区域 -->
      <el-table :data="userlist"
                border
                stripe>
        <!-- stripe: 斑马条纹
        border：边框-->
        <el-table-column type="index"
                         label="序号"></el-table-column>
        <el-table-column prop="id"
                         label="学号"></el-table-column>
        <el-table-column prop="name"
                         label="姓名"></el-table-column>
        <el-table-column prop="department"
                         label="学院"></el-table-column>
        <el-table-column prop="major"
                         label="专业"></el-table-column>
        <el-table-column prop="class"
                         label="班级"></el-table-column>
        <el-table-column prop="phone"
                         label="手机号"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="primary"
                       icon="el-icon-edit"
                       size="mini"
                       circle
                       @click="showEditDialog(scope.row.id)"></el-button>
            <el-button type="danger"
                       icon="el-icon-delete"
                       size="mini"
                       circle
                       @click="removeUserById(scope.row.id)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页区域 -->
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="queryInfo.pageNo"
                     :page-size="queryInfo.pageSize"
                     layout="total, prev, pager, next, jumper"
                     :total="total"></el-pagination>
    </el-card>
  
    <!-- 添加用户的对话框 -->
    <el-dialog title="添加用户"
               :visible.sync="addDialogVisible"
               width="50%"
               @close="addDialogClosed">
      <!-- 内容主体 -->
      <el-form :model="addUserForm"
               ref="addUserFormRef"
               :rules="addUserFormRules"
               label-width="100px">
        <el-form-item label="学号"
                      prop="id">
          <el-input v-model="addUserForm.id"></el-input>
        </el-form-item>
         <el-form-item label="姓名"
                      prop="name">
          <el-input v-model="addUserForm.name"></el-input>
        </el-form-item>
        <el-form-item label="学院"
                      prop="department">
          <el-input v-model="addUserForm.department"></el-input>
        </el-form-item>
        <el-form-item label="专业"
                      prop="major">
          <el-input v-model="addUserForm.major"></el-input>
        </el-form-item>
        <el-form-item label="班级"
                      prop="class">
          <el-input v-model="addUserForm.class"></el-input>
        </el-form-item>
        <el-form-item label="手机号"
                      prop="phone">
          <el-input v-model="addUserForm.phone"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer"
            class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="addUser">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 修改用户的对话框 -->
    <el-dialog title="修改用户信息"
               :visible.sync="editDialogVisible"
               width="50%"
               @close="editDialogClosed">
      <!-- 内容主体 -->
      <el-form :model="editUserForm"
               ref="editUserFormRef"
               :rules="editUserFormRules"
               label-width="70px">
        <el-form-item label="学号">id
          <el-input v-model="editUserForm.id"
                    disabled></el-input>
        </el-form-item>
        <el-form-item label="姓名"
                      prop="name">
          <el-input v-model="editUserForm.name"></el-input>
        </el-form-item>
         <el-form-item label="学院"
                      prop="department">
          <el-input v-model="editUserForm.department"></el-input>
        </el-form-item>
         <el-form-item label="专业"
                      prop="major">
          <el-input v-model="editUserForm.major"></el-input>
        </el-form-item>
         <el-form-item label="班级"
                      prop="class">
          <el-input v-model="editUserForm.class"></el-input>
        </el-form-item>
        <el-form-item label="手机号"
                      prop="phone">
          <el-input v-model="editUserForm.phone"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer"
            class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary"
                   @click="editUser">确 定</el-button>
      </span>
    </el-dialog>


  </div>
</template>

<script>
export default {
  name : "userlist",
  data() {
    return {
      
       
      
      queryInfo: {
        query: "",
        // 当前页数
        pageNo: 1,
        // 每页显示多少数据
        pageSize: 5,
      },
      userlist: [
        {
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
      ],
      total: 0,
       addDialogVisible: false,
      // 用户添加
      addUserForm: {
        username: "",
        password: "",
        email: "",
        mobile: "",
      },
      addUserFormRules: {
        id: [
          { required: true, message: "请输入学号", trigger: "blur" },
          {
            min: 2,
            max: 10,
            trigger: "blur",
          },
        ],
        name: [
          { required: true, message: "请输入用户姓名", trigger: "blur" }],
        department: [{ required: true, message: "请输入学院", trigger: "blur" }],
        major: [{ required: true, message: "请输入专业", trigger: "blur" }],
        class: [{ required: true, message: "请输入班级", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
        ],
      },
      // 修改用户
      editDialogVisible: false,
      editUserForm: {},
      // 编辑用户表单验证
      editUserFormRules: {
         name: [
          { required: true, message: "请输入用户姓名", trigger: "blur" }],
        department: [{ required: true, message: "请输入学院", trigger: "blur" }],
        major: [{ required: true, message: "请输入专业", trigger: "blur" }],
        class: [{ required: true, message: "请输入班级", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
        ],
      },
      // 分配角色对话框
      setRoleDialogVisible: false,
      // 当前需要被分配角色的用户
      userInfo: {},
      // 所有角色数据列表
      rolesLsit: [],
      // 已选中的角色Id值
      selectRoleId: "",
    }
  },
  methods: {
    async getUserList() {
      const { data: res } = await this.$http.get("user/list", {
        params: this.queryInfo,
      });
      if (res.code !== 200) {
        return this.$message.error("获取用户列表失败！");
      }
      this.userlist = res.data.records;
      this.total = res.data.total;
    },
    // 监听 pageSize改变的事件
    handleSizeChange(newSize) {
      // console.log(newSize)
      this.queryInfo.pageSize = newSize;
      this.getUserList();
    },
    // 监听 页码值 改变事件
    handleCurrentChange(newSize) {
      // console.log(newSize)
      this.queryInfo.pageNo = newSize;
      this.getUserList();
    },
    // 监听 添加用户对话框的关闭事件
    addDialogClosed() {
      this.$refs.addUserFormRef.resetFields();
    },
    // 添加用户
    addUser() {
      // 提交请求前，表单预验证
      this.$refs.addUserFormRef.validate(async (valid) => {
        // console.log(valid)
        // 表单预校验失败
        if (!valid) return;
        const { data: res } = await this.$http.post(
          "user/modify",
          this.addUserForm
        );
        if (res.code !== 200) {
          this.$message.error("添加用户失败！");
          return;
        }
        this.$message.success("添加用户成功！");
        // 隐藏添加用户对话框
        this.addDialogVisible = false;
        this.getUserList();
      });
    },
    // 编辑用户信息
    async showEditDialog(id) {
      const { data: res } = await this.$http.get("user/" + id);
      if (res.code !== 200) {
        return this.$message.error("查询用户信息失败！");
      }
      this.editUserForm = res.data;
      this.editDialogVisible = true;
    },
    // 监听修改用户对话框的关闭事件
    editDialogClosed() {
      this.$refs.editUserFormRef.resetFields();
    },
    // 修改用户信息
    editUser() {
      // 提交请求前，表单预验证
      this.$refs.editUserFormRef.validate(async (valid) => {
        // console.log(valid)
        // 表单预校验失败
        if (!valid) return;
        const { data: res } = await this.$http.post("user/modify", {
          id: this.editUserForm.id,
          email: this.editUserForm.email,
          mobile: this.editUserForm.mobile,
        });
        if (res.code !== 200) {
          this.$message.error("更新用户信息失败！");
        }
        // 隐藏添加用户对话框
        this.editDialogVisible = false;
        this.$message.success("更新用户信息成功！");
        this.getUserList();
      });
    },
    // 删除用户
    async removeUserById(id) {
      const confirmResult = await this.$confirm("确定删除该用户?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).catch((err) => err);
      // 点击确定 返回值为：confirm
      // 点击取消 返回值为： cancel
      if (confirmResult !== "confirm") {
        return this.$message.info("已取消删除");
      }
      const { data: res } = await this.$http.post("user/remove/" + id);
      if (res.code !== 200) return this.$message.error("删除用户失败！");
      this.$message.success("删除用户成功！");
      this.getUserList();
    },
  },
}
</script>

<style scoped>
.people-list-title {
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid #e5e5e5;
}

</style>
