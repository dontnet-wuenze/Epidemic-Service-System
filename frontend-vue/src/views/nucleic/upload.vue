<template>
  <div>
    <div class="content-box-title">
      <el-row :gutter="20" type="flex" justify="space-around"><h2>检测结果上传</h2></el-row>
    </div>
    <div class="content-box-nucleic">
      <div>
        <span></span>
      </div>
      <el-upload
      class="upload-demo"
      action=""
      :on-change="handleChange"
      :show-file-list="false"
      :auto-upload="false">
      <el-button size="small" type="primary" style="margin-bottom:15px;">读取excel文件</el-button>
      </el-upload>
      <el-table 
        :data="tableData" 
        max-height="250"
        border
        style="width: 100%">
        <el-table-column prop="id" label="学工号" width="180"></el-table-column>
        <el-table-column prop="date" label="日期" width="180"></el-table-column>
        <el-table-column prop="result_show" label="结果" width="180"></el-table-column>
        <el-table-column
          fixed="right"
          label="操作">
          <template slot-scope="scope">
            <el-button
              @click.native.prevent = "deleteRow(scope.$index, tableData)"
              type="text">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-divider></el-divider>
      <div style="display:flex;"><h4>添加条目</h4></div>
      <el-row>
        <el-col :span="6" :offset="1">
          <el-input v-model="input_id" placeholder="请输入学工号"></el-input>
        </el-col>
        <el-col :span="5" :offset="1">
          <el-date-picker type="date" v-model="input_date" placeholder="选择检测日期"></el-date-picker>
        </el-col>
        <el-col :span="6" >
          <el-select v-model="input_result" filterable clearable placeholder="请选择检测结果" >
            <el-option label = "阳性" value="阳性"></el-option>
            <el-option label = "阴性" value="阴性"></el-option>
          </el-select>          
        </el-col>

        <el-button @click="addlist()">
        添加
        </el-button>
      </el-row>
      <el-divider></el-divider>
      <el-button-group>
        <el-button type="primary" @click="deleteAll">清空</el-button>
        <el-button type="primary" @click="submitAll">提交</el-button>
      </el-button-group> 
    </div>
  </div>
</template>

<script>

import {nucleicUpload} from '@/api/nucleic.js';
  export default{
    data() {
      return {
        tableData: [],
        fileContent: '',
        file: '',
        data: '',
        input_id: '',
        input_date: '',
        input_result: ''
      };
    },
  methods: {
    deleteRow(index, rows) {
      rows.splice(index, 1);
    },
    addlist(){
      const obj = {};
      const _this = this;
      if(_this.input_id == '' || _this.input_date == '' || _this.input_result == ''){
        this.$message.error('请完善全部项后提交');
      }
      else{
        obj.id = _this.input_id;
        obj.date = _this.input_date.getFullYear() + '/' + (_this.input_date.getMonth() + 1) + '/' + _this.input_date.getDate();
        obj.result_show = _this.input_result;

        if(_this.input_result == "阳性")
          obj.result = 1;
        else
          obj.result = 0;

        _this.tableData.push(obj);
        _this.input_id = '';
        _this.input_date = '';
        _this.input_result = '';
      }
    },
    handleDelete (item) {
      console.log('handleDelete', item)
    },
    handelEdit (item) {
      console.log('handleDelete', item)
    },
  // 核心部分代码(handleChange 和 importfile)
    handleChange (file) {
      console.log(file);
      this.fileContent = file.raw
      const fileName = file.name
      const fileType = fileName.substring(fileName.lastIndexOf('.') + 1)
      if (this.fileContent) {
    
        if (fileType === 'xlsx' || fileType === 'xls') {
          this.importfile(this.fileContent)
        }

        else {
          this.$message({
            type: 'warning',
            message: '附件格式错误，请重新上传！'})
        }
      } 
      else {
        this.$message({
          type: 'warning',
          message: '请上传附件！'})
      }
    },


    importfile (obj) {
      console.log(obj);
      const reader = new FileReader()
      const _this = this
      reader.readAsArrayBuffer(obj)

      reader.onload = function () {
      const buffer = reader.result
      const bytes = new Uint8Array(buffer)
      const length = bytes.byteLength
      let binary = ''
      for (let i = 0; i < length; i++) 
      {
        binary += String.fromCharCode(bytes[i])
      }

      const XLSX = require('xlsx')
      const wb = XLSX.read(binary, { type: 'binary'})

        const outdata = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]])
        this.data = [...outdata]
        const arr = []
        this.data.map(v => {
        const obj = { }
        const temp_date = new Date((v.date-25567) * 24 * 3600000 - 5 * 60 * 1000 - 43 * 1000  - 24 * 3600000 - 8 * 3600000)
        obj.id = v.id
        obj.date = temp_date.getFullYear() + '-' + (temp_date.getMonth() + 1)+ '-' + temp_date.getDate()
        obj.result_show=v.result
        if(v.result == "阳性")
          obj.result = 1;
        else
          obj.result = 0;
        arr.push(obj)
        })
        _this.tableData = _this.tableData.concat(arr)
        console.log(arr)
      }
    },
    deleteAll: function(){
      alert("您将清空全部数据")
      this.tableData = []
      this.fileContent = ''
      this.data = ''
      this.file = ''
    },
    submitAll: function(){
      console.log(this.tableData)
      nucleicUpload(this.tableData).then(res=>{
        if(res.data.success == 0)
          this.$message.error('传输失败');
        else
          this.$message.success('传输成功');
        });
    },
  }
}
</script> 

<style scoped>
.content-box-title h3{
  font-size: 1.3rem;
  color: #333;
  width: 70%;
  float: left;
}

.content-box-nucleic {
  width: 70%;
  height: 600px;
  border-radius: 10px;
  background: #fff;
  margin: 0 auto;
  position: relative;
}

.content-box-nucleic-header {
  text-align: center;
  color: #666;
}

.textGray {
  color: #666;
}

</style>