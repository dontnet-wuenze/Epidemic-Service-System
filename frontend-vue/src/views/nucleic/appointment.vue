<template>
  <div>
    <div>
      <h2>核酸检测预约</h2>
    </div>

    <div class="usermsg">
      <h3>基本信息</h3>
      <div>
        <span>姓名</span>
        <span>*</span>
        <input type="text" v-model="userName" name="userName" required>
      </div>
      <div>
        <span>学号</span>
        <span>*</span>
        <input type="number" v-model="userNo" name="userNo" required>
      </div>
      <h3>预约信息</h3>
      <div>
        <span>预约检测点</span>
        <span>*</span>
        <select name="appAddress" v-model="appAddress">
          <option v-for="item in availableAddress" :key="item"> {{item}}</option>
        </select>
      </div>
      <div>
        <span>预约日期</span>
        <span>*</span>
        <input type="date" v-model="appDate" name="appDate">
      </div>
      <div>
        <span>预约时间</span>
        <span>*</span>
        <select name="appTime" v-model="appTime">
          <option v-for="item in availableTime" :key="item"> {{item}}</option>
        </select>
      </div>
    </div>
    <div>
      <a href="javascript:;" @click="submitAppointment">
        <span>提交申请</span>
      </a>
    </div>
  </div>
</template>

<script>

export default {
  name: "appointment",
  data() {
    return {
      userName: "",
      userNo: "",
      appDate: "",
      appTime: "",
      appAddress: "",
      availableAddress:[
        "紫金港操场",
        "玉泉邵体馆",
        "西溪校医院"
      ],
      availableTime:[
        "上午10:00-11:30",
        "下午2:00-3:30",
        "下午3:30-5:00",        
        "下午5:00-6:30"
      ]
    };
  },
  methods: {
    /*showAmount: function(){
      var that = this;
      if(that.appDate != "" && that.appTime != ""&& that.appAddress != "")
        return 100;
    }*/
    submitAppointment: function() {
      if(this.userName != "" && this.userNo != "" && this.appAddress != "" && this.appDate != "" && this.appTime != "")
      {
        alert("提交成功");
      }
      else 
        alert("提交失败！");
    }
  
  }
}
</script>

