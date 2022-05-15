<template>
  <!-- <div>
    <div>
      <span>学工号(被检测者)</span>
      <span>*</span>
      <input type="sID" v-model="studentNo" name = "studentNo" required
        maxlength="10" pattern="[0-9]">
    </div>
    <div>
      <span>检测日期</span>
      <span>*</span>
      <input type="date" v-model="detectionDate" name="detectionDate">
    </div>
    <div>
      <span>检测结果</span>
      <span>*</span>
      <select name="decResult" v-model="dtcResult">
          <option v-for="item in availableResult" :key="item"> {{item}}</option>
      </select>
    </div>
    <div>
      <button @click="submitResult">提交结果</button>
    </div>
  </div> -->
  <div>
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
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="学工号" width="180"></el-table-column>
      <el-table-column prop="date" label="日期" width="180"></el-table-column>
      <el-table-column prop="result" label="结果" width="180"></el-table-column>
    </el-table>
    <el-button-group>
      <el-button type="primary" @click="deleteAll">清空</el-button>
      <el-button type="primary" @click="submitAll">提交</el-button>
    </el-button-group> 
  </div>
</template>

<script>
// export default {
//     name:"upload",
//     data(){
//       return{
//         doctorNo:"",
//         studentNo:"",
//         detectionDate:"",
//         //DetectionTime:"",
//         dtcResult:"",
//         availableResult:[
//           "阴性",
//           "阳性"
//         ],
//         stuArray: [],
//         dateArray: [],
//         resultArray: []
//       };
//     },
//     methods:{
//       submitResult: function(){
//         if(this.studentNo != "" && this.detectionDate != "" && this.dtcResult != "")
//         {
//           this.stuArray.push(this.studentNo);
//           this.dateArray.push(this.detectionDate);
//           this.resultArray.push(this.dtcResult);
//           alert("提交成功");
//         }
//         else
//         {
//           alert("提交失败");
//         }
//       }
//     }
//}
  export default{
    data() {
      return {
        tableData: [],
        fileContent: '',
        file: '',
        data: ''
      };
    },
  methods: {
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
        obj.id = v.id
        obj.date = v.date
        obj.result=v.result
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
    }
  }
}
</script> 
