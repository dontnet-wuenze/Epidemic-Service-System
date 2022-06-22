<template>
  <div>
    <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="approval-container">
      <div class="approval-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>表单审批</h3></div>
      </div>
      <el-table :data="tabledata" style="width: 80%; margin: auto" max-height="550">
        <el-table-column prop="id" label="表单编号" width="150"></el-table-column>
        <el-table-column prop="applicant" label="申请人" width="150"></el-table-column>
        <el-table-column prop="application_time" label="申请时间" width="200"></el-table-column>
        <el-table-column prop="application_type" label="申请种类" width="200"></el-table-column>
        <el-table-column prop="approval_status" label="审批状态" width="150"></el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handle_approval(scope.row)" type="text" size="medium">审批</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!---学生通行码申请--->
      <el-dialog title="学生通行码申请审批" :visible.sync="stu_passphrase_form_visible" fullscreen="true">
        <div style="position: relative; z-index: 0">
          <button @click="close()" style="margin-left:3%; margin-bottom: 10%;" class="button">关闭</button>
        </div>
        <div class="container">
          <div class="scroll-container-form">
            <el-form ref="StuPassphraseApplication" :label-position="labelPosition" :model="stu_passphrase_approval" :rules="rules">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="申请编号">
                    <el-input v-model="stu_passphrase_approval.id" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" :offset="3">
                  <el-form-item label="申请日期">
                    <el-date-picker type="date" v-model="stu_passphrase_approval.date" placeholder="请选择日期" readonly="true"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>基础信息</h4></div>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="姓名">
                    <el-input v-model="stu_passphrase_approval.name" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" :offset="2">
                  <el-form-item label="学号">
                    <el-input v-model="stu_passphrase_approval.st_id" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="stu_passphrase_approval.telenum" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="stu_passphrase_approval.email" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所在学院" prop="institute">
                    <el-select v-model="stu_passphrase_approval.institute" disabled filterable clearable placeholder="请选择学院">
                      <el-option
                        v-for="item in institutes"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="所在校区" prop="campus">
                    <el-select v-model="stu_passphrase_approval.campus" disabled filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区" value="Zijingang"></el-option>
                      <el-option label="玉泉校区" value="Yuquan"></el-option>
                      <el-option label="西溪校区" value="Xixi"></el-option>
                      <el-option label="华家池校区" value="Huajiachi"></el-option>
                      <el-option label="之江校区" value="Zhijiang"></el-option>
                      <el-option label="海宁校区" value="Haining"></el-option>
                      <el-option label="舟山校区" value="Zhoushan"></el-option>
                      <el-option label="宁波校区" value="Ningbo"></el-option>
                      <el-option label="工程师学院" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="是否住校" prop="in_residence">
                <el-radio-group v-model="stu_passphrase_approval.in_residence" disabled>
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="家庭地址" prop="address">
                <el-input style="width: 400px" v-model="stu_passphrase_approval.address" readonly="true"></el-input>
              </el-form-item>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="家长姓名" prop="parent_name">
                    <el-input v-model="stu_passphrase_approval.parent_name" readonly="true" style="width: 175px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="联系电话" prop="parent_tele">
                    <el-input v-model="stu_passphrase_approval.parent_tele" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>申请信息</h4></div>
              <el-form-item label="最近14天内是否有发热、咳嗽、乏力、咽痛、腹泻等症状?" prop="fever">
                <el-radio-group v-model="stu_passphrase_approval.fever" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内是否有接触确诊/疑似病例或无症状感染者?" prop="contact_patient">
                <el-radio-group v-model="stu_passphrase_approval.contact_patient" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近28天内是否有国（境）外旅居史?" prop="abroad">
                <el-radio-group v-model="stu_passphrase_approval.abroad" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="是否接触过从国（境）外返回但未满28天的人员?" prop="contact_abroad">
                <el-radio-group v-model="stu_passphrase_approval.contact_abroad" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内一同居住的人员是否有上述情况?" prop="roommate">
                <el-radio-group v-model="stu_passphrase_approval.roommate" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="以上地区是否为澳门地区?" prop="macao">
                <el-radio-group v-model="stu_passphrase_approval.macao" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径高风险地区?" prop="high_risk">
                <el-radio-group v-model="stu_passphrase_approval.high_risk" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径中风险地区?" prop="medium_risk">
                <el-radio-group v-model="stu_passphrase_approval.medium_risk" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径杭州市内封控区或管控区?" prop="control_area">
                <el-radio-group v-model="stu_passphrase_approval.control_area" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前14天内或返校过程中是否旅居或途径杭州市内防范区?" prop="prevent_area">
                <el-radio-group v-model="stu_passphrase_approval.prevent_area" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="浙江省健康码登记证件号" prop="certificate">
                <el-input v-model="stu_passphrase_approval.certificate" style="width: 250px"></el-input>
              </el-form-item>
              <el-form-item label="浙江省健康码状态" prop="health_code">
                <el-select v-model="stu_passphrase_approval.health_code" disabled style="width 150px">
                  <el-option label="绿码" value="green"></el-option>
                  <el-option label="黄码" value="yellow"></el-option>
                  <el-option label="红码" value="red"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="请上传浙江省健康码" prop="health_code_screenshot">
                <br>
                <el-upload ref="stu_health_code_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="请上传14天通行数据查询截图" prop="route_screenshot">
                <br>
                <el-upload ref="stu_route_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="14天行程卡是否有杭州外其他地区星号" prop="route_star">
                <el-radio-group v-model="stu_passphrase_approval.route_star" disabled>
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="请上传48小时核酸阴性证明截图" prop="nucleic_negative">
                <br>
                <el-upload ref="stu_nucleic_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="疫苗接种情况" prop="vaccine">
                <el-select v-model="stu_passphrase_approval.vaccine" disabled>
                  <el-option label="未接种" value="non"></el-option>
                  <el-option label="已接种第一针" value="first"></el-option>
                  <el-option label="已接种第二针（未满六个月）" value="second_less_than_six_months"></el-option>
                  <el-option label="已接种第二针（已满六个月）" value="second_more_than_six_months"></el-option>
                  <el-option label="已接种第三针" value="third"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="请上传支付宝健康疫苗接种页截图（支付宝-健康码-新冠疫苗接种）" prop="vaccine_screenshot">
                <br>
                <el-upload ref="stu_vaccine_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="stu_passphrase_approval.remark" readonly="true" type="textarea" :autosize="{minRows: 2, maxRows: 4}" style="width: 500px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>来校信息</h4></div>
              <el-form-item label="当前所在地" prop="location">
                <el-cascader :options="locations" v-model="stu_passphrase_approval.location" disabled @change="handleChange"></el-cascader>
              </el-form-item>
              <el-form-item label="到校日期" prop="return_date">
                <el-date-picker type="date" v-model="stu_passphrase_approval.return_date" readonly="true" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计到校时段" prop="return_period">
                <el-select type="date" v-model="stu_passphrase_approval.return_period" disabled placeholder="请选择时段">
                  <el-option label="上午" value="morning"></el-option>
                  <el-option label="下午" value="afternoon"></el-option>
                  <el-option label="晚上" value="evening"></el-option>
                  <el-option label="凌晨" value="dawn"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="交通工具" prop="vehicle_kind">
                <el-row>
                  <el-col span="5">
                    <el-select v-model="stu_passphrase_approval.vehicle_kind" disabled>
                      <el-option label="飞机" value="plane"></el-option>
                      <el-option label="火车" value="train"></el-option>
                      <el-option label="长途汽车" value="coach"></el-option>
                      <el-option label="自驾" value="self_driving"></el-option>
                      <el-option label="其他" value="others"></el-option>
                    </el-select>
                  </el-col>
                  <el-col span="6">
                    <el-input v-if="stu_passphrase_approval.vehicle_kind == 'others'" v-model="stu_passphrase_approval.vehicle" readonly="true" prop="vehicle"></el-input>
                  </el-col>
                </el-row>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站日期" prop="arrive_date">
                <el-date-picker type="date" v-model="stu_passphrase_approval.arrive_date" readonly="true" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站时间" prop="arrive_time">
                <el-time-select  v-model="stu_passphrase_approval.arrive_time" readonly="true" placeholder="请选择时间"
                  :picker-options="{start: '0:00', end: '24:00', step: '0:10'}"></el-time-select>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="航班车次" prop="transport_num">
                <el-input v-model="stu_passphrase_approval.transport_num" readonly="true" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="到达车站/机场" prop="arrive_port">
                <el-select v-model="stu_passphrase_approval.arrive_port" disabled>
                  <el-option label="城站火车站" value="train_station"></el-option>
                  <el-option label="杭州东站" value="Hangzhou_East"></el-option>
                  <el-option label="萧山机场" value="Xiaoshan_airport"></el-option>
                  <el-option label="汽车客运站" value="bus_station"></el-option>
                  <el-option label="其他" value="others"></el-option>
                </el-select>
              </el-form-item>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>个人承诺</h4></div>
              <el-form-item prop="promise">
                <el-checkbox v-model="stu_passphrase_approval.promise" disabled label="true">
                  本人承诺：以上情况信息属实。如有相关变化，将及时报告院系。到校途中严格做好个人防护；到校后服从疫情防控要求，做好个人健康管理，如实报告相关信息。
                  <br>
                  来校前14天内未到过（含途径）中高风险地区所在县（市、区）及要求全域管控区域，本人及共同居住家庭成员返校前14天未有发热、干咳、咽痛、流涕、腹泻、
                  <br>
                  乏力、嗅（味）觉减退、肌肉酸痛等症状。如有瞒报，本人愿意承担由此引起的责任
                </el-checkbox>
              </el-form-item>
              <el-divider></el-divider>
              <el-row>
                <el-col span="10">
                  <el-form-item label="审核人意见" prop="auditor_advice">
                    <el-radio-group v-model="stu_passphrase_approval.auditor_advice">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="审核人备注" prop="auditor_remark">
                    <el-input v-model="stu_passphrase_approval.auditor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StuPassphraseApplication')">提交表单</el-button>
                </el-form-item>
              </div>
            </el-form>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl">
            </el-dialog>
          </div>
        </div>
      </el-dialog>
      <!---教职工通行码申请--->
      <el-dialog title="教职工通行码申请审批" :visible.sync="staff_passphrase_form_visible" fullscreen="true">
        <div style="position: relative; z-index: 0">
          <button @click="close()" style="margin-left:3%; margin-bottom: 10%;" class="button">关闭</button>
        </div>
        <div class="container">
          <div class="scroll-container-form">
            <el-form ref="StaffPassphraseApplication" :label-position="labelPosition" :model="staff_passphrase_approval" :rules="rules">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="申请编号">
                    <el-input v-model="staff_passphrase_approval.id" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" :offset="3">
                  <el-form-item label="申请日期">
                    <el-date-picker type="date" v-model="staff_passphrase_approval.date" placeholder="请选择日期" readonly="true"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>基础信息</h4></div>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="姓名">
                    <el-input v-model="staff_passphrase_approval.name" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" :offset="2">
                  <el-form-item label="工号">
                    <el-input v-model="staff_passphrase_approval.st_id" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="staff_passphrase_approval.telenum" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="staff_passphrase_approval.email" readonly="true" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所在学院" prop="institute">
                    <el-select v-model="staff_passphrase_approval.institute" disabled filterable clearable placeholder="请选择学院">
                      <el-option
                        v-for="item in institutes"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="所在校区" prop="campus">
                    <el-select v-model="staff_passphrase_approval.campus" disabled filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区" value="Zijingang"></el-option>
                      <el-option label="玉泉校区" value="Yuquan"></el-option>
                      <el-option label="西溪校区" value="Xixi"></el-option>
                      <el-option label="华家池校区" value="Huajiachi"></el-option>
                      <el-option label="之江校区" value="Zhijiang"></el-option>
                      <el-option label="海宁校区" value="Haining"></el-option>
                      <el-option label="舟山校区" value="Zhoushan"></el-option>
                      <el-option label="宁波校区" value="Ningbo"></el-option>
                      <el-option label="工程师学院" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="居住地址" prop="address">
                <el-input style="width: 400px" v-model="staff_passphrase_approval.address" readonly="true"></el-input>
              </el-form-item>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>申请信息</h4></div>
              <el-form-item label="最近14天内是否有发热、咳嗽、乏力、咽痛、腹泻等症状?" prop="fever">
                <el-radio-group v-model="staff_passphrase_approval.fever" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内是否有接触确诊/疑似病例或无症状感染者?" prop="contact_patient">
                <el-radio-group v-model="staff_passphrase_approval.contact_patient" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近28天内是否有国（境）外旅居史?" prop="abroad">
                <el-radio-group v-model="staff_passphrase_approval.abroad" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="是否接触过从国（境）外返回但未满28天的人员?" prop="contact_abroad">
                <el-radio-group v-model="staff_passphrase_approval.contact_abroad" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内一同居住的人员是否有上述情况?" prop="roommate">
                <el-radio-group v-model="staff_passphrase_approval.roommate" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="以上地区是否为澳门地区?" prop="macao">
                <el-radio-group v-model="staff_passphrase_approval.macao" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径高风险地区?" prop="high_risk">
                <el-radio-group v-model="staff_passphrase_approval.high_risk" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径中风险地区?" prop="medium_risk">
                <el-radio-group v-model="staff_passphrase_approval.medium_risk" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径杭州市内封控区或管控区?" prop="control_area">
                <el-radio-group v-model="staff_passphrase_approval.control_area" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前14天内或返校过程中是否旅居或途径杭州市内防范区?" prop="prevent_area">
                <el-radio-group v-model="staff_passphrase_approval.prevent_area" disabled>
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="浙江省健康码登记证件号" prop="certificate">
                <el-input v-model="staff_passphrase_approval.certificate" style="width: 250px" readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="浙江省健康码状态" prop="health_code">
            <el-select v-model="staff_passphrase_approval.health_code" style="width 150px" disabled>
              <el-option label="绿码" value="green"></el-option>
              <el-option label="黄码" value="yellow"></el-option>
              <el-option label="红码" value="red"></el-option>
            </el-select>
          </el-form-item>
              <el-form-item label="请上传浙江省健康码" prop="health_code_screenshot">
                <br>
                <el-upload ref="staff_health_code_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="请上传14天通行数据查询截图" prop="route_screenshot">
                <br>
                <el-upload ref="staff_route_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="14天行程卡是否有杭州外其他地区星号" prop="route_star">
                <el-radio-group v-model="staff_passphrase_approval.route_star" disabled>
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="请上传48小时核酸阴性证明截图" prop="nucleic_negative">
                <br>
                <el-upload ref="staff_nucleic_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-form-item label="疫苗接种情况" prop="vaccine">
                <el-select v-model="staff_passphrase_approval.vaccine" disabled>
                  <el-option label="未接种" value="non"></el-option>
                  <el-option label="已接种第一针" value="first"></el-option>
                  <el-option label="已接种第二针（未满六个月）" value="second_less_than_six_months"></el-option>
                  <el-option label="已接种第二针（已满六个月）" value="second_more_than_six_months"></el-option>
                  <el-option label="已接种第三针" value="third"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="请上传支付宝健康疫苗接种页截图（支付宝-健康码-新冠疫苗接种）" prop="vaccine_screenshot">
                <br>
                <el-upload ref="staff_vaccine_upload" action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
              </el-form-item>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="staff_passphrase_approval.remark" readonly="true" type="textarea" :autosize="{minRows: 2, maxRows: 4}" style="width: 500px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>来校信息</h4></div>
              <el-form-item label="当前所在地" prop="location">
                <el-cascader :options="locations" v-model="staff_passphrase_approval.location" disabled @change="handleChange"></el-cascader>
              </el-form-item>
              <el-form-item label="到校日期" prop="return_date">
                <el-date-picker type="date" v-model="staff_passphrase_approval.return_date" readonly="true" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计到校时段" prop="return_period">
                <el-select type="date" v-model="staff_passphrase_approval.return_period" disabled placeholder="请选择时段">
                  <el-option label="上午" value="morning"></el-option>
                  <el-option label="下午" value="afternoon"></el-option>
                  <el-option label="晚上" value="evening"></el-option>
                  <el-option label="凌晨" value="dawn"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="交通工具" prop="vehicle_kind">
                <el-row>
                  <el-col span="5">
                    <el-select v-model="staff_passphrase_approval.vehicle_kind" disabled>
                      <el-option label="飞机" value="plane"></el-option>
                      <el-option label="火车" value="train"></el-option>
                      <el-option label="长途汽车" value="coach"></el-option>
                      <el-option label="自驾" value="self_driving"></el-option>
                      <el-option label="其他" value="others"></el-option>
                    </el-select>
                  </el-col>
                  <el-col span="6">
                    <el-input v-if="staff_passphrase_approval.vehicle_kind == 'others'" v-model="staff_passphrase_approval.vehicle" readonly="true" prop="vehicle"></el-input>
                  </el-col>
                </el-row>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站日期" prop="arrive_date">
                <el-date-picker type="date" v-model="staff_passphrase_approval.arrive_date" readonly="true" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站时间" prop="arrive_time">
                <el-time-select  v-model="staff_passphrase_approval.arrive_time" readonly="true" placeholder="请选择时间"
                  :picker-options="{start: '0:00', end: '24:00', step: '0:10'}"></el-time-select>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="航班车次" prop="transport_num">
                <el-input v-model="staff_passphrase_approval.transport_num" readonly="true" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="到达车站/机场" prop="arrive_port">
                <el-select v-model="staff_passphrase_approval.arrive_port" disabled>
                  <el-option label="城站火车站" value="train_station"></el-option>
                  <el-option label="杭州东站" value="Hangzhou_East"></el-option>
                  <el-option label="萧山机场" value="Xiaoshan_airport"></el-option>
                  <el-option label="汽车客运站" value="bus_station"></el-option>
                  <el-option label="其他" value="others"></el-option>
                </el-select>
              </el-form-item>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>个人承诺</h4></div>
              <el-form-item prop="promise">
                <el-checkbox v-model="staff_passphrase_approval.promise" disabled label="true">
                  本人承诺：以上情况信息属实。如有相关变化，将及时报告院系。到校途中严格做好个人防护；到校后服从疫情防控要求，做好个人健康管理，如实报告相关信息。
                  <br>
                  来校前14天内未到过（含途径）中高风险地区所在县（市、区）及要求全域管控区域，本人及共同居住家庭成员返校前14天未有发热、干咳、咽痛、流涕、腹泻、
                  <br>
                  乏力、嗅（味）觉减退、肌肉酸痛等症状。如有瞒报，本人愿意承担由此引起的责任
                </el-checkbox>
              </el-form-item>
              <el-divider></el-divider>
              <el-row>
                <el-col span="10">
                  <el-form-item label="审核人意见" prop="auditor_advice">
                    <el-radio-group v-model="staff_passphrase_approval.auditor_advice">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="审核人备注" prop="auditor_remark">
                    <el-input v-model="staff_passphrase_approval.auditor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StaffPassphraseApplication')">提交表单</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { regionData } from "element-china-area-data";
import { departmentList } from "@/components/statistic/department"
import { get_form_approval_list, get_stu_passphrase_form, get_staff_passphrase_form,
         stu_passphrase_submit, staff_passphrase_submit } from "@/api/approval"

export default {
  name:"form_approval",
  data() {
    return{
      stu_passphrase_form_visible: false,
      staff_passphrase_form_visible: false,
      dialogVisible: false,
      dialogImageUrl: '',
      locations: regionData,
      institutes: departmentList,
      tabledata: [],
      rules:{
        auditor_advice: { required: true, message: "请选择是否通过", trigger: "change"}
      },

      stu_passphrase_approval: {
        id: '',
        date: '',
        name: '',
        st_id: '',
        telenum: '',
        email: '',
        institute: '',
        campus: '',
        in_residence: '',
        address: '',
        parent_name: '',
        parent_tele: '',
        fever: '',
        contact_patient: '',
        abroad: '',
        contact_abroad: '',
        roommate: '',
        macao: '',
        high_risk: '',
        medium_risk: '',
        control_area: '',
        prevent_area: '',
        certificate: '',
        health_code: '',
        route_star: '',
        vaccine: '',
        remark: '',
        location:[],
        return_date: '',
        return_period: '',
        vehicle_kind: '',
        vehicle: '',
        arrive_date: '',
        arrive_time: '',
        transport_num: '',
        arrive_port: '',
        promise: '',
        auditor_advice: '',
        auditor_remark: ''
      },
      staff_passphrase_approval: {
        id: '',
        date: '',
        name: '',
        st_id: '',
        telenum: '',
        email: '',
        institute: '',
        campus: '',
        address: '',
        fever: '',
        contact_patient: '',
        abroad: '',
        contact_abroad: '',
        roommate: '',
        macao: '',
        high_risk: '',
        medium_risk: '',
        control_area: '',
        prevent_area: '',
        certificate: '',
        health_code: '',
        route_star: '',
        vaccine: '',
        remark: '',
        location:[],
        return_date: '',
        return_period: '',
        vehicle_kind: '',
        vehicle: '',
        arrive_date: '',
        arrive_time: '',
        transport_num: '',
        arrive_port: '',
        promise: '',
        auditor_advice: '',
        auditor_remark: ''
      }
    }
  },
  methods:{
    goOff() {
      this.$router.go(-1);
    },
    close() {
      this.stu_passphrase_form_visible = false;
      this.staff_passphrase_form_visible = false;
    },
    handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
    },
    handle_approval(row) {
      if(row.approval_status === "等待审核") {
        if(row.application_type === "学生通行码申请") {
          this.stu_passphrase_form_visible = true;
          get_stu_passphrase_form(row.id).then(res => {
            this.stu_passphrase_approval.id = res.data.id;
            this.stu_passphrase_approval.date = res.data.date;
            this.stu_passphrase_approval.name = res.data.name;
            this.stu_passphrase_approval.st_id = res.data.st_id;
            this.stu_passphrase_approval.telenum = res.data.telenum;
            this.stu_passphrase_approval.email = res.data.email;
            this.stu_passphrase_approval.institute = res.data.institute;
            this.stu_passphrase_approval.campus = res.data.campus;
            this.stu_passphrase_approval.in_residence = res.data.in_residence;
            this.stu_passphrase_approval.address = res.data.address;
            this.stu_passphrase_approval.parent_name = res.data.parent_name;
            this.stu_passphrase_approval.parent_tele = res.data.parent_tele;
            this.stu_passphrase_approval.fever = res.data.fever;
            this.stu_passphrase_approval.contact_patient = res.data.contact_patient;
            this.stu_passphrase_approval.abroad = res.data.abroad;
            this.stu_passphrase_approval.contact_abroad = res.data.contact_abroad;
            this.stu_passphrase_approval.roommate = res.data.roommate;
            this.stu_passphrase_approval.macao = res.data.macao;
            this.stu_passphrase_approval.high_risk = res.data.high_risk;
            this.stu_passphrase_approval.medium_risk = res.data.medium_risk;
            this.stu_passphrase_approval.control_area = res.data.control_area;
            this.stu_passphrase_approval.prevent_area = res.data.prevent_area;
            this.stu_passphrase_approval.certificate = res.data.certificate;
            this.stu_passphrase_approval.health_code = res.data.health_code;
            this.stu_passphrase_approval.route_star = res.data.route_star;
            this.stu_passphrase_approval.vaccine = res.data.vaccine;
            this.stu_passphrase_approval.remark = res.data.remark;
            this.stu_passphrase_approval.location = res.data.location;
            this.stu_passphrase_approval.return_date = res.data.return_date;
            this.stu_passphrase_approval.return_period = res.data.return_period;
            this.stu_passphrase_approval.vehicle_kind = res.data.vehicle_kind;
            this.stu_passphrase_approval.vehicle = res.data.vehicle;
            this.stu_passphrase_approval.arrive_date = res.data.arrive_date;
            this.stu_passphrase_approval.arrive_time = res.data.arrive_time;
            this.stu_passphrase_approval.transport_num = res.data.transport_num;
            this.stu_passphrase_approval.arrive_port = res.data.arrive_port;
            this.stu_passphrase_approval.promise = res.data.promise;
            this.$refs['stu_health_code_upload'].uploadFiles = res.data.health_code_list;
            this.$refs['stu_route_upload'].uploadFiles = res.data.route_list;
            this.$refs['stu_nucleic_upload'].uploadFiles = res.data.nucleic_list;
            this.$refs['stu_vaccine_upload'].uploadFiles = res.data.vaccine_list;
          }).catch(error => {
            console.log(error);
          })
        }
        else if(row.application_type == "教职工通行码申请") {
          this.staff_passphrase_form_visible = true;
          get_staff_passphrase_form(row.id).then(res => {
            this.staff_passphrase_approval.id = res.data.id;
            this.staff_passphrase_approval.date = res.data.date;
            this.staff_passphrase_approval.name = res.data.name;
            this.staff_passphrase_approval.st_id = res.data.st_id;
            this.staff_passphrase_approval.telenum = res.data.telenum;
            this.staff_passphrase_approval.email = res.data.email;
            this.staff_passphrase_approval.institute = res.data.institute;
            this.staff_passphrase_approval.campus = res.data.campus;
            this.staff_passphrase_approval.address = res.data.address;
            this.staff_passphrase_approval.fever = res.data.fever;
            this.staff_passphrase_approval.contact_patient = res.data.contact_patient;
            this.staff_passphrase_approval.abroad = res.data.abroad;
            this.staff_passphrase_approval.contact_abroad = res.data.contact_abroad;
            this.staff_passphrase_approval.roommate = res.data.roommate;
            this.staff_passphrase_approval.macao = res.data.macao;
            this.staff_passphrase_approval.high_risk = res.data.high_risk;
            this.staff_passphrase_approval.medium_risk = res.data.medium_risk;
            this.staff_passphrase_approval.control_area = res.data.control_area;
            this.staff_passphrase_approval.prevent_area = res.data.prevent_area;
            this.staff_passphrase_approval.certificate = res.data.certificate;
            this.staff_passphrase_approval.health_code = res.data.health_code;
            this.staff_passphrase_approval.route_star = res.data.route_star;
            this.staff_passphrase_approval.vaccine = res.data.vaccine;
            this.staff_passphrase_approval.remark = res.data.remark;
            this.staff_passphrase_approval.location = res.data.location;
            this.staff_passphrase_approval.return_date = res.data.return_date;
            this.staff_passphrase_approval.return_period = res.data.return_period;
            this.staff_passphrase_approval.vehicle_kind = res.data.vehicle_kind;
            this.staff_passphrase_approval.vehicle = res.data.vehicle;
            this.staff_passphrase_approval.arrive_date = res.data.arrive_date;
            this.staff_passphrase_approval.arrive_time = res.data.arrive_time;
            this.staff_passphrase_approval.transport_num = res.data.transport_num;
            this.staff_passphrase_approval.arrive_port = res.data.arrive_port;
            this.staff_passphrase_approval.promise = res.data.promise;
            this.$refs['staff_health_code_upload'].uploadFiles = res.data.health_code_list;
            this.$refs['staff_route_upload'].uploadFiles = res.data.route_list;
            this.$refs['staff_nucleic_upload'].uploadFiles = res.data.nucleic_list;
            this.$refs['staff_vaccine_upload'].uploadFiles = res.data.vaccine_list;
          }).catch(error => {
            console.log(error)
          })
        }
      }
      else {
        this.$message.error("审批已完成")
      }
    },
    submitForm(form_name) {
      this.$refs[form_name].validate((valid) =>{
        if(valid) {
          if(form_name == "StuPassphraseApplication") {
            var stu_submit_data = {
              id: this.stu_passphrase_approvalid,
              date: this.stu_passphrase_approvaldate,
              name: this.stu_passphrase_approvalname,
              st_id: this.stu_passphrase_approvalst_id,
              telenum: this.stu_passphrase_approvaltelenum,
              email: this.stu_passphrase_approvalemail,
              institute: this.stu_passphrase_approvalinstitute,
              campus: this.stu_passphrase_approvalcampus,
              in_residence: this.stu_passphrase_approvalin_residence,
              address: this.stu_passphrase_approvaladdress,
              parent_name: this.stu_passphrase_approvalparent_name,
              parent_tele: this.stu_passphrase_approvalparent_tele,
              fever: this.stu_passphrase_approvalfever,
              contact_patient: this.stu_passphrase_approvalcontact_patient,
              abroad: this.stu_passphrase_approvalabroad,
              contact_abroad: this.stu_passphrase_approvalcontact_abroad,
              roommate: this.stu_passphrase_approvalroommate,
              macao: this.stu_passphrase_approvalmacao,
              high_risk: this.stu_passphrase_approvalhigh_risk,
              medium_risk: this.stu_passphrase_approvalmedium_risk,
              control_area: this.stu_passphrase_approvalcontrol_area,
              prevent_area: this.stu_passphrase_approvalprevent_area,
              certificate: this.stu_passphrase_approvalcertificate,
              health_code: this.stu_passphrase_approvalhealth_code,
              health_code_list: this.$refs['stu_health_code_upload'].uploadFiles,
              route_list: this.$refs['stu_route_upload'].uploadFiles,
              route_star: this.stu_passphrase_approvalroute_star,
              nucleic_list: this.$refs['stu_nucleic_upload'].uploadFiles,
              vaccine: this.stu_passphrase_approvalvaccine,
              vaccine_list: this.$refs['stu_vaccine_upload'].uploadFiles,
              remark: this.stu_passphrase_approvalremark,
              location: this.stu_passphrase_approvallocation,
              return_date: this.stu_passphrase_approvalreturn_date,
              return_period: this.stu_passphrase_approvalreturn_period,
              vehicle_kind: this.stu_passphrase_approvalvehicle_kind,
              vehicle: this.stu_passphrase_approvalvehicle,
              arrive_date: this.stu_passphrase_approvalarrive_date,
              arrive_time: this.stu_passphrase_approvalarrive_time,
              transport_num: this.stu_passphrase_approvaltransport_num,
              arrive_port: this.stu_passphrase_approvalarrive_port,
              promise: this.stu_passphrase_approvalpromise,
              auditor_advice: this.stu_passphrase_approvalauditor_advice,
              auditor_remark: this.stu_passphrase_approvalauditor_remark
            }
            stu_passphrase_submit(stu_submit_data).then(res => {
              this.$message.success('提交成功!');
            }).catch(error => {
                this.$message.error(error)
            })
          } else {
            var staff_submit_data = {
              id: this.staff_passphrase_approvalid,
              date: this.staff_passphrase_approvaldate,
              name: this.staff_passphrase_approvalname,
              st_id: this.staff_passphrase_approvalst_id,
              telenum: this.staff_passphrase_approvaltelenum,
              email: this.staff_passphrase_approvalemail,
              institute: this.staff_passphrase_approvalinstitute,
              campus: this.staff_passphrase_approvalcampus,
              address: this.staff_passphrase_approvaladdress,
              fever: this.staff_passphrase_approvalfever,
              contact_patient: this.staff_passphrase_approvalcontact_patient,
              abroad: this.staff_passphrase_approvalabroad,
              contact_abroad: this.staff_passphrase_approvalcontact_abroad,
              roommate: this.staff_passphrase_approvalroommate,
              macao: this.staff_passphrase_approvalmacao,
              high_risk: this.staff_passphrase_approvalhigh_risk,
              medium_risk: this.staff_passphrase_approvalmedium_risk,
              control_area: this.staff_passphrase_approvalcontrol_area,
              prevent_area: this.staff_passphrase_approvalprevent_area,
              certificate: this.staff_passphrase_approvalcertificate,
              health_code: this.staff_passphrase_approvalhealth_code,
              health_code_list: this.$refs['staff_health_code_upload'].uploadFiles,
              route_list: this.$refs['staff_route_upload'].uploadFiles,
              route_star: this.staff_passphrase_approvalroute_star,
              nucleic_list: this.$refs['staff_nucleic_upload'].uploadFiles,
              vaccine: this.staff_passphrase_approvalvaccine,
              vaccine_list: this.$refs['staff_vaccine_upload'].uploadFiles,
              remark: this.staff_passphrase_approvalremark,
              location: this.staff_passphrase_approvallocation,
              return_date: this.staff_passphrase_approvalreturn_date,
              return_period: this.staff_passphrase_approvalreturn_period,
              vehicle_kind: this.staff_passphrase_approvalvehicle_kind,
              vehicle: this.staff_passphrase_approvalvehicle,
              arrive_date: this.staff_passphrase_approvalarrive_date,
              arrive_time: this.staff_passphrase_approvalarrive_time,
              transport_num: this.staff_passphrase_approvaltransport_num,
              arrive_port: this.staff_passphrase_approvalarrive_port,
              promise: this.staff_passphrase_approvalpromise,
              auditor_advice: this.staff_passphrase_approvalauditor_advice,
              auditor_remark: this.staff_passphrase_approvalauditor_remark
            }
            staff_passphrase_submit(staff_submit_data).then(res => {
              this.$message.success('提交成功!');
            }).catch(error => {
                this.$message.error(error)
            })
          }
          this.$message.success('提交成功!');
        }
        else {
          this.$message.error('表单填写有误，请检查后重新提交!');
          return false;
        }
      });
    }
  },
  async mounted() {
    let _this = this;
    get_form_approval_list().then(res => {
      _this.tabledata = res.data
    }).catch(error => {
      console.log(error);
    })
  }
}
</script>


<style scoped>
.button {
  position: absolute;
  z-index: 0;
  left: 20px;
  top: 10px;
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

.approval-container {
  height: 100%;
  margin: 10px auto;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

.approval-container-title{
  height: 150px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}

.container{
  height: 100%;
  margin: 10px auto;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

.scroll-container-form {
  width: 100%;
}
</style>

<style>
.submit-btn{
  margin-top: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
