<template>
  <div>
    <div style="position: relative; z-index: 0">
        <button @click="goOff()" style="margin-left:3%; margin-bottom: 10%;" class="button">返回</button>
    </div>
    <div class="approval-container">
      <div class="approval-container-title">
        <div style="display: flex; justify-content: center; align-items: center"><h3>表单审批</h3></div>
      </div>
      <el-table :data="tabledata" style="width: 100%" max-height="550">
        <el-table-column prop="applicant" label="申请人" width="150"></el-table-column>
        <el-table-column prop="application_time" label="申请时间" width="250"></el-table-column>
        <el-table-column prop="application_type" label="申请种类" width="200"></el-table-column>
        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-button @click="handle_approval(scope.row.application_type)" type="text" size="medium">审批</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!---学生离校申请--->
      <el-dialog title="学生离校申请审批" :visible.sync="stu_leave_form_visible" fullscreen = true>
        <div class="container">
          <div class="scroll-container-form">
            <el-form ref="StuLeaveApproval" :label-position="labelPosition" :model="stu_leave_approval" label-width="auto" :rules="rules">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="申请编号">
                    <el-input v-model="stu_leave_approval.id" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" :offset="3">
                  <el-form-item label="申请日期">
                    <el-date-picker type="date" v-model="stu_leave_approval.date" placeholder="请选择日期" readonly="true"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>基础信息</h4></div>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="姓名">
                    <el-input v-model="stu_leave_approval.name" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" :offset="2">
                  <el-form-item label="学号">
                    <el-input v-model="stu_leave_approval.stu_id" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="stu_leave_approval.telenum"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="stu_leave_approval.email"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所在学院" prop="institute">
                    <el-select v-model="stu_leave_approval.institute" filterable clearable placeholder="请选择学院">
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
                    <el-select v-model="stu_leave_approval.campus" filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区 Zijingang" value="Zijingang"></el-option>
                      <el-option label="玉泉校区 Yuquan" value="Yuquan"></el-option>
                      <el-option label="西溪校区 Xixi" value="Xixi"></el-option>
                      <el-option label="华家池校区 Huajiachi" value="Huajiachi"></el-option>
                      <el-option label="之江校区 Zhijiang" value="Zhijiang"></el-option>
                      <el-option label="海宁校区 Haining" value="Haining"></el-option>
                      <el-option label="舟山校区 Zhoushan" value="Zhoushan"></el-option>
                      <el-option label="宁波校区 Ningbo" value="Ningbo"></el-option>
                      <el-option label="工程师学院 Polytechnic Institue" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心 Innovation Center" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="是否住校" prop="in_residence">
                <el-radio-group v-model="stu_leave_approval.in_residence">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="家庭地址" prop="address">
                <el-input style="width: 400px" v-model="stu_leave_approval.address" ></el-input>
              </el-form-item>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="家长姓名" prop="parent_name">
                    <el-input v-model="stu_leave_approval.parent_name"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="联系电话" prop="parent_tele">
                    <el-input v-model="stu_leave_approval.parent_tele"></el-input>
                  </el-form-item> 
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="导师/班主任姓名" prop="tutor_name">
                    <el-input v-model="stu_leave_approval.tutor_name"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="联系电话" prop="tutor_tele">
                    <el-input v-model="stu_leave_approval.tutor_tele"></el-input>
                  </el-form-item> 
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>离校信息</h4></div>
              <el-form-item label="离校日期" prop="leave_date">
                <el-date-picker type="date" v-model="stu_leave_approval.leave_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计返校日期" prop="return_date">
                <el-date-picker type="date" v-model="stu_leave_approval.return_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="往返交通工具" prop="vehicle">
                <el-select v-model="stu_leave_approval.vehicle_kind">
                  <el-option label="家庭自备车辆" value="family_car"></el-option>
                  <el-option label="公共交通工具" value="public_transport"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item v-if="stu_leave_approval.vehicle == 'public_transport'" label="具体车次" prop="transport_num">
                <el-input v-model="stu_leave_approval.transport_num" style="width: 500px"></el-input>
              </el-form-item>
              <el-row>
                <el-form-item label="离校前往目的地" prop="location">
                  <el-cascader :options="locations" clearable filterable v-model="stu_leave_approval.location" @change="handleChange"></el-cascader>
                </el-form-item>
              </el-row>
              <el-row>
                <el-col span="10">
                  <el-form-item label="具体地址" prop="address_1">
                    <el-input v-model="stu_leave_approval.address_1"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="10">
                  <el-form-item label="事由" prop="reason_1">
                    <el-input v-model="stu_leave_approval.reason_1" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="stu_leave_approval.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>离校报备情况</h4></div>
                <el-form-item prop="promise">
                  <el-checkbox v-model="stu_leave_approval.promise" label="true">
                    本人承诺：以上情况信息属实。家长知情并同意离校。离校后按照疫情防控要求做好个人健康管理，如实报告相关信息
                  </el-checkbox>
                </el-form-item>
              <el-divider></el-divider>
              <el-row>
                <el-col span="10">
                  <el-form-item label="辅导员意见" prop="counsellor_advice">
                    <el-radio-group v-model="stu_leave_approval.counsellor_remark">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="辅导员备注" prop="counsellor_remark">
                    <el-input v-model="stu_leave_approval.counsellor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StuLeaveForm')">提交表单</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </div>
      </el-dialog>
      <!---学生通行码申请--->
      <el-dialog title="学生通行码申请审批" :visible.sync="stu_passphrase_form_visible" fullscreen="true">
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
                    <el-input v-model="stu_passphrase_approval.stu_id" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="stu_passphrase_approval.telenum" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="stu_passphrase_approval.email" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所在学院" prop="institute">
                    <el-select v-model="stu_passphrase_approval.institute" filterable clearable placeholder="请选择学院">
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
                    <el-select v-model="stu_passphrase_approval.campus" filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区 Zijingang" value="Zijingang"></el-option>
                      <el-option label="玉泉校区 Yuquan" value="Yuquan"></el-option>
                      <el-option label="西溪校区 Xixi" value="Xixi"></el-option>
                      <el-option label="华家池校区 Huajiachi" value="Huajiachi"></el-option>
                      <el-option label="之江校区 Zhijiang" value="Zhijiang"></el-option>
                      <el-option label="海宁校区 Haining" value="Haining"></el-option>
                      <el-option label="舟山校区 Zhoushan" value="Zhoushan"></el-option>
                      <el-option label="宁波校区 Ningbo" value="Ningbo"></el-option>
                      <el-option label="工程师学院 Polytechnic Institue" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心 Innovation Center" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="是否住校" prop="in_residence">
                <el-radio-group v-model="stu_passphrase_approval.in_residence">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="辅导员列表" prop="counsellor">
                <el-select v-model="stu_passphrase_approval.counsellor" clearable filterable placeholder="请选择辅导员">
                  <el-option
                    v-for="item in counsellors"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    <span style="float: left">{{ item.label }}</span>
                    <span style="float: right; color: #8492a6">{{ item.value }}</span>
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="家庭地址" prop="address">
                <el-input style="width: 400px" v-model="stu_passphrase_approval.address" ></el-input>
              </el-form-item>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="家长姓名" prop="parent_name">
                    <el-input v-model="stu_passphrase_approval.parent_name" style="width: 175px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="联系电话" prop="parent_tele">
                    <el-input v-model="stu_passphrase_approval.parent_tele" style="width: 220px"></el-input>
                  </el-form-item> 
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>申请信息</h4></div>
              <el-form-item label="最近14天内是否有发热、咳嗽、乏力、咽痛、腹泻等症状?" prop="symptom">
                <el-radio-group v-model="stu_passphrase_approval.fever">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内是否有接触确诊/疑似病例或无症状感染者?" prop="contact_patient">
                <el-radio-group v-model="stu_passphrase_approval.contact_patient">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近28天内是否有国（境）外旅居史?" prop="abroad">
                <el-radio-group v-model="stu_passphrase_approval.abroad">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="是否接触过从国（境）外返回但未满28天的人员?" prop="contact_abroad">
                <el-radio-group v-model="stu_passphrase_approval.contact_abroad">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内一同居住的人员是否有上述情况?" prop="roommate">
                <el-radio-group v-model="stu_passphrase_approval.roommate">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="以上地区是否为澳门地区?" prop="macao">
                <el-radio-group v-model="stu_passphrase_approval.macao">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径高风险地区?" prop="high_risk">
                <el-radio-group v-model="stu_passphrase_approval.high_risk">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径中风险地区?" prop="medium_risk">
                <el-radio-group v-model="stu_passphrase_approval.medium_risk">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径杭州市内封控区或管控区?" prop="control_area">
                <el-radio-group v-model="stu_passphrase_approval.control_area">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前14天内或返校过程中是否旅居或途径杭州市内防范区?" prop="prevent_area">
                <el-radio-group v-model="stu_passphrase_approval.prevent_area">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="浙江省健康码登记证件号" prop="certificate">
                <el-input v-model="stu_passphrase_approval.certificate" style="width: 250px" readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="浙江省健康码状态" prop="health_code">
                <el-input v-model="stu_passphrase_approval.health_code" style="width 150px" readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="是否对健康码状态有异议" prop="health_code_objection">
                <el-radio-group v-model="stu_passphrase_approval.health_code_objection">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.health_code_objection == 'true'"
                label="请上传浙江省健康码" prop="health_code_screenshot">
                <br>
                <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="请上传14天通行数据查询截图" prop="route_screenshot">
                <br>
                <el-upload action="#" :filelist="fileList" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file, fileList)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="14天行程卡是否有杭州外其他地区星号" prop="route_star">
                <el-radio-group v-model="stu_passphrase_approval.route_star">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="请上传18小时核酸阴性证明截图" prop="nucleic_negative">
                <br>
                <el-upload action="#" :filelist="fileList" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file, fileList)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="疫苗接种情况" prop="vaccine">
                <el-select v-model="stu_passphrase_approval.vaccine">
                  <el-option label="未接种" value="non"></el-option>
                  <el-option label="已接种第一针" value="first"></el-option>
                  <el-option label="已接种第二针（未满六个月）" value="second_less_than_six_months"></el-option>
                  <el-option label="已接种第二针（已满六个月）" value="second_more_than_six_months"></el-option>
                  <el-option label="已接种第三针" value="third"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="请上传支付宝健康疫苗接种页截图（支付宝-健康码-新冠疫苗接种）" prop="vaccine_screenshot">
                <br>
                <el-upload action="#" :filelist="fileList" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file, fileList)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="stu_passphrase_approval.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}" style="width: 500px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>来校信息</h4></div>
              <el-form-item label="当前所在地" prop="location">
                <el-cascader :options="locations" v-model="stu_passphrase_approval.location" @change="handleChange"></el-cascader>
              </el-form-item>
              <el-form-item label="到校日期" prop="return_date">
                <el-date-picker type="date" v-model="stu_passphrase_approval.return_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计到校时段" prop="return_period">
                <el-select type="date" v-model="stu_passphrase_approval.return_period" placeholder="请选择时段">
                  <el-option label="上午" value="morning"></el-option>
                  <el-option label="下午" value="afternoon"></el-option>
                  <el-option label="晚上" value="evening"></el-option>
                  <el-option label="凌晨" value="dawn"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="交通工具" prop="vehicle_kind">
                <el-row>
                  <el-col span="5">
                    <el-select v-model="stu_passphrase_approval.vehicle_kind">
                      <el-option label="飞机" value="plane"></el-option>
                      <el-option label="火车" value="train"></el-option>
                      <el-option label="长途汽车" value="coach"></el-option>
                      <el-option label="自驾" value="self_driving"></el-option>
                      <el-option label="其他" value="others"></el-option>
                    </el-select>
                  </el-col>
                  <el-col span="6">
                    <el-input v-if="stu_passphrase_approval.vehicle_kind == 'others'" v-model="stu_passphrase_approval.vehicle" prop="vehicle"></el-input>
                  </el-col>
                </el-row>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站日期" prop="arrive_date">
                <el-date-picker type="date" v-model="stu_passphrase_approval.arrive_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站时间" prop="arrive_time">
                <el-time-select  v-model="stu_passphrase_approval.arrive_time" placeholder="请选择时间"
                  :picker-options="{start: '0:00', end: '24:00', step: '0:10'}"></el-time-select>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="航班车次" prop="transport_num">
                <el-input v-model="stu_passphrase_approval.transport_num" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item v-if="stu_passphrase_approval.vehicle_kind == 'plane' || stu_passphrase_approval.vehicle_kind == 'train' || stu_passphrase_approval.vehicle_kind == 'coach'"
                label="到达车站/机场" prop="arrive_port">
                <el-select v-model="stu_passphrase_approval.arrive_port">
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
                <el-checkbox v-model="stu_passphrase_approval.promise" label="true">
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
                  <el-form-item label="辅导员意见" prop="counsellor_advice">
                    <el-radio-group v-model="stu_leave_approval.counsellor_remark">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="辅导员备注" prop="counsellor_remark">
                    <el-input v-model="stu_leave_approval.counsellor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StuPassphraseApplication')">提交表单</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </div>
      </el-dialog>
      <!---教职工离校申请--->
      <el-dialog title="教职工离校申请审批" :visible.sync="staff_leave_form_visible" fullscreen="true">
        <div class="container">
          <div class="scroll-container-form">
            <el-form ref="StaffLeaveForm" :label-position="labelPosition" :model="staff_leave_approval" label-width="auto" :rules="rules">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="申请编号">
                    <el-input v-model="staff_leave_approval.id" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7" :offset="3">
                  <el-form-item label="申请日期">
                    <el-date-picker type="date" v-model="staff_leave_approval.date" placeholder="请选择日期" readonly="true"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>基础信息</h4></div>
              <el-row>
                <el-col :span="5">
                  <el-form-item label="姓名">
                    <el-input v-model="staff_leave_approval.name" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5" :offset="2">
                  <el-form-item label="工号">
                    <el-input v-model="staff_leave_approval.staff_id" readonly="true"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="staff_leave_approval.telenum"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="staff_leave_approval.email"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所属学院/部门" prop="institute">
                    <el-select v-model="staff_leave_approval.institute" filterable clearable placeholder="请选择学院/部门">
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
                    <el-select v-model="staff_leave_approval.campus" filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区 Zijingang" value="Zijingang"></el-option>
                      <el-option label="玉泉校区 Yuquan" value="Yuquan"></el-option>
                      <el-option label="西溪校区 Xixi" value="Xixi"></el-option>
                      <el-option label="华家池校区 Huajiachi" value="Huajiachi"></el-option>
                      <el-option label="之江校区 Zhijiang" value="Zhijiang"></el-option>
                      <el-option label="海宁校区 Haining" value="Haining"></el-option>
                      <el-option label="舟山校区 Zhoushan" value="Zhoushan"></el-option>
                      <el-option label="宁波校区 Ningbo" value="Ningbo"></el-option>
                      <el-option label="工程师学院 Polytechnic Institue" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心 Innovation Center" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="居住地址" prop="address">
                <el-input style="width: 400px" v-model="staff_leave_approval.address" ></el-input>
              </el-form-item>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>离校信息</h4></div>
              <el-form-item label="离校日期" prop="leave_date">
                <el-date-picker type="date" v-model="staff_leave_approval.leave_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计返校日期" prop="return_date">
                <el-date-picker type="date" v-model="staff_leave_approval.return_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="往返交通工具" prop="vehicle">
                <el-select v-model="staff_leave_approval.vehicle_kind">
                  <el-option label="家庭自备车辆" value="family_car"></el-option>
                  <el-option label="公共交通工具" value="public_transport"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item v-if="staff_leave_approval.vehicle == 'public_transport'" label="具体车次" prop="transport_num">
                <el-input v-model="staff_leave_approval.transport_num" style="width: 500px"></el-input>
              </el-form-item>
              <el-row>
                <el-form-item label="离校前往目的地" prop="location">
                  <el-cascader :options="locations" v-model="staff_leave_approval.location" @change="handleChange"></el-cascader>
                </el-form-item>
              </el-row>
              <el-row>
                <el-col span="10">
                  <el-form-item label="具体地址" prop="address_1">
                    <el-input v-model="staff_leave_approval.address_1"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="10">
                  <el-form-item label="事由" prop="reason_1">
                    <el-input v-model="staff_leave_approval.reason_1" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="staff_leave_approval.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>离校报备情况</h4></div>
              <el-form-item prop="promise">
                <el-checkbox v-model="staff_leave_approval.promise" label="true">
                  本人承诺：以上情况信息属实。离校后按照疫情防控要求做好个人健康管理，如实报告相关信息
                </el-checkbox>
              </el-form-item>
              <el-divider></el-divider>
              <el-row>
                <el-col span="10">
                  <el-form-item label="审核人意见" prop="counsellor_advice">
                    <el-radio-group v-model="stu_leave_approval.counsellor_remark">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="审核人备注" prop="counsellor_remark">
                    <el-input v-model="stu_leave_approval.counsellor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StaffLeaveForm')">提交表单</el-button>
                </el-form-item>
              </div>
            </el-form>
          </div>
        </div>
      </el-dialog>
      <!---教职工通行码申请--->
      <el-dialog title="教职工通行码申请审批" :visible.sync="staff_passphrase_form_visible" fullscreen="true">
        <div class="container">
          <div class="scroll-container-form">
            <el-form ref="StuPassphraseApplication" :label-position="labelPosition" :model="staff_passphrase_approval" :rules="rules">
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
                    <el-input v-model="staff_passphrase_approval.staff_id" readonly="true" style="width: 200px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="手机号码" prop="telenum">
                    <el-input v-model="staff_passphrase_approval.telenum" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="邮箱地址" prop="email">
                    <el-input v-model="staff_passphrase_approval.email" style="width: 220px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6">
                  <el-form-item label="所在学院" prop="institute">
                    <el-select v-model="staff_passphrase_approval.institute" filterable clearable placeholder="请选择学院">
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
                    <el-select v-model="staff_passphrase_approval.campus" filterable clearable placeholder="请选择校区">
                      <el-option label="紫金港校区 Zijingang" value="Zijingang"></el-option>
                      <el-option label="玉泉校区 Yuquan" value="Yuquan"></el-option>
                      <el-option label="西溪校区 Xixi" value="Xixi"></el-option>
                      <el-option label="华家池校区 Huajiachi" value="Huajiachi"></el-option>
                      <el-option label="之江校区 Zhijiang" value="Zhijiang"></el-option>
                      <el-option label="海宁校区 Haining" value="Haining"></el-option>
                      <el-option label="舟山校区 Zhoushan" value="Zhoushan"></el-option>
                      <el-option label="宁波校区 Ningbo" value="Ningbo"></el-option>
                      <el-option label="工程师学院 Polytechnic Institue" value="Polytechnic Institue"></el-option>
                      <el-option label="杭州国际科创中心 Innovation Center" value="Innovation Center"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="领导列表" prop="leader">
                <el-select v-model="staff_passphrase_approval.leader" clearable filterable placeholder="请选择领导">
                  <el-option
                    v-for="item in leader"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    <span style="float: left">{{ item.label }}</span>
                    <span style="float: right; color: #8492a6">{{ item.value }}</span>
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="居住地址" prop="address">
                <el-input style="width: 400px" v-model="staff_passphrase_approval.address" ></el-input>
              </el-form-item>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>申请信息</h4></div>
              <el-form-item label="最近14天内是否有发热、咳嗽、乏力、咽痛、腹泻等症状?" prop="symptom">
                <el-radio-group v-model="staff_passphrase_approval.fever">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内是否有接触确诊/疑似病例或无症状感染者?" prop="contact_patient">
                <el-radio-group v-model="staff_passphrase_approval.contact_patient">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近28天内是否有国（境）外旅居史?" prop="abroad">
                <el-radio-group v-model="staff_passphrase_approval.abroad">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="是否接触过从国（境）外返回但未满28天的人员?" prop="contact_abroad">
                <el-radio-group v-model="staff_passphrase_approval.contact_abroad">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="最近14天内一同居住的人员是否有上述情况?" prop="roommate">
                <el-radio-group v-model="staff_passphrase_approval.roommate">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="以上地区是否为澳门地区?" prop="macao">
                <el-radio-group v-model="staff_passphrase_approval.macao">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径高风险地区?" prop="high_risk">
                <el-radio-group v-model="staff_passphrase_approval.high_risk">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径中风险地区?" prop="medium_risk">
                <el-radio-group v-model="staff_passphrase_approval.medium_risk">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前21天内或返校过程中是否旅居或途径杭州市内封控区或管控区?" prop="control_area">
                <el-radio-group v-model="staff_passphrase_approval.control_area">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="来校前14天内或返校过程中是否旅居或途径杭州市内防范区?" prop="prevent_area">
                <el-radio-group v-model="staff_passphrase_approval.prevent_area">
                  <el-radio label=true>是</el-radio>
                  <el-radio label=false>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="浙江省健康码登记证件号" prop="certificate">
                <el-input v-model="staff_passphrase_approval.certificate" style="width: 250px" readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="浙江省健康码状态" prop="health_code">
                <el-input v-model="staff_passphrase_approval.health_code" style="width 150px" readonly="true"></el-input>
              </el-form-item>
              <el-form-item label="是否对健康码状态有异议" prop="health_code_objection">
                <el-radio-group v-model="staff_passphrase_approval.health_code_objection">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.health_code_objection == 'true'"
                label="请上传浙江省健康码" prop="health_code_screenshot">
                <br>
                <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="请上传14天通行数据查询截图" prop="route_screenshot">
                <br>
                <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="14天行程卡是否有杭州外其他地区星号" prop="route_star">
                <el-radio-group v-model="staff_passphrase_approval.route_star">
                  <el-radio label="true">是</el-radio>
                  <el-radio label="false">否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="请上传18小时核酸阴性证明截图" prop="nucleic_negative">
                <br>
                <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-form-item label="疫苗接种情况" prop="vaccine">
                <el-select v-model="staff_passphrase_approval.vaccine">
                  <el-option label="未接种" value="non"></el-option>
                  <el-option label="已接种第一针" value="first"></el-option>
                  <el-option label="已接种第二针（未满六个月）" value="second_less_than_six_months"></el-option>
                  <el-option label="已接种第二针（已满六个月）" value="second_more_than_six_months"></el-option>
                  <el-option label="已接种第三针" value="third"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="请上传支付宝健康疫苗接种页截图（支付宝-健康码-新冠疫苗接种）" prop="vaccine_screenshot">
                <br>
                <el-upload action="#" list-type="picture-card" :limit="1" :auto-upload="false">
                  <i slot="default" class="el-icon-plus"></i>
                  <div slot="file" slot-scope="{file}">
                    <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                    <span class="el-upload-list__item-actions">
                      <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                        <i class="el-icon-zoom-in"></i>
                      </span>
                      <span class="el-upload-list__item-delete" @click="handleRemove(file)">
                        <i class="el-icon-delete"></i>
                      </span>
                    </span>
                  </div>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                  <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
              </el-form-item>
              <el-row>
                <el-col span="12">
                  <el-form-item label="备注">
                    <el-input v-model="staff_passphrase_approval.remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}" style="width: 500px"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div style="display: flex;"><h4>来校信息</h4></div>
              <el-form-item label="当前所在地" prop="location">
                <el-cascader :options="locations" v-model="staff_passphrase_approval.location" @change="handleChange"></el-cascader>
              </el-form-item>
              <el-form-item label="到校日期" prop="return_date">
                <el-date-picker type="date" v-model="staff_passphrase_approval.return_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="预计到校时段" prop="return_period">
                <el-select type="date" v-model="staff_passphrase_approval.return_period" placeholder="请选择时段">
                  <el-option label="上午" value="morning"></el-option>
                  <el-option label="下午" value="afternoon"></el-option>
                  <el-option label="晚上" value="evening"></el-option>
                  <el-option label="凌晨" value="dawn"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="交通工具" prop="vehicle_kind">
                <el-row>
                  <el-col span="5">
                    <el-select v-model="staff_passphrase_approval.vehicle_kind">
                      <el-option label="飞机" value="plane"></el-option>
                      <el-option label="火车" value="train"></el-option>
                      <el-option label="长途汽车" value="coach"></el-option>
                      <el-option label="自驾" value="self_driving"></el-option>
                      <el-option label="其他" value="others"></el-option>
                    </el-select>
                  </el-col>
                  <el-col span="6">
                    <el-input v-if="staff_passphrase_approval.vehicle_kind == 'others'" v-model="staff_passphrase_approval.vehicle" prop="vehicle"></el-input>
                  </el-col>
                </el-row>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站日期" prop="arrive_date">
                <el-date-picker type="date" v-model="staff_passphrase_approval.arrive_date" placeholder="请选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="预计到站时间" prop="arrive_time">
                <el-time-select  v-model="staff_passphrase_approval.arrive_time" placeholder="请选择时间"
                  :picker-options="{start: '0:00', end: '24:00', step: '0:10'}"></el-time-select>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="航班车次" prop="transport_num">
                <el-input v-model="staff_passphrase_approval.transport_num" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item v-if="staff_passphrase_approval.vehicle_kind == 'plane' || staff_passphrase_approval.vehicle_kind == 'train' || staff_passphrase_approval.vehicle_kind == 'coach'"
                label="到达车站/机场" prop="arrive_port">
                <el-select v-model="staff_passphrase_approval.arrive_port">
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
                <el-checkbox v-model="staff_passphrase_approval.promise" label="true">
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
                  <el-form-item label="审核人意见" prop="counsellor_advice">
                    <el-radio-group v-model="stu_leave_approval.counsellor_remark">
                      <el-radio label="true">同意</el-radio>
                      <el-radio label="false">不同意</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col span="12">
                  <el-form-item label="审核人备注" prop="counsellor_remark">
                    <el-input v-model="stu_leave_approval.counsellor_remark" type="textarea" :autosize="{minRows: 2, maxRows: 4}"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <div class="submit-btn">
                <el-form-item>
                  <el-button type="primary" @click="submitForm('StuPassphraseApplication')">提交表单</el-button>
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

export default {
  name:"form_approval",
  data() {
    return{
      stu_leave_form_visible: false,
      stu_passphrase_form_visible: false,
      staff_leave_form_visible: false,
      staff_passphrase_form_visible: false,
      locations:regionData,
      institutes: [{
       value: 'BaoWeiChu',
       label: '安全保卫处' 
      },{
        value: 'BeiJing',
        label: '北京研究院'
      },{
        value: 'BenKe',
        label: '本科生院'
      },{
        value: 'CaiGou',
        label: '采购管理办公室'
      },{
        value: 'DangWei',
        label: '党委办公室(含保密办公室、信访办公室)'
      }],
      rules:{

      },

      stu_leave_approval:{
        id: '1145141919810',
        name: 'Lingsing',
        stu_id: '3190103176',
        date: Date.now()
      },
      stu_passphrase_approval: {
        id: '1145141919810',
        name: 'Lingsing',
        stu_id: '3190103176',
        date: Date.now()
      },
      staff_leave_approval: {
        id: '1145141919810',
        name: 'Lingsing',
        stu_id: '3190103176',
        date: Date.now()
      },
      staff_passphrase_approval: {
        id: '1145141919810',
        name: 'Lingsing',
        stu_id: '3190103176',
        date: Date.now()
      },

      tabledata: [{
        applicant: '张三',
        application_time: '2020-5-23 12:05:07',
        application_type: '学生离校申请'
      }, {
        applicant: '李四',
        application_time: '2020-5-23 12:05:05',
        application_type: '学生通行码申请'
      }, {
        applicant: '王五',
        application_time: '2020-5-23 12:05:07',
        application_type: '教职工离校申请'
      }, {
        applicant: '赵六',
        application_time: '2020-5-23 12:05:07',
        application_type: '教职工通行码申请'
      }]
    }
  },
  methods:{
    goOff() {
      this.$router.go(-1);
    },
    handle_approval(application_type) {
      if(application_type == '学生离校申请') {
        this.stu_leave_form_visible = true;
      }
      else if(application_type == "学生通行码申请") {
        this.stu_passphrase_form_visible = true;
      }
      else if(application_type == "教职工离校申请") {
        this.staff_leave_form_visible = true;
      }
      else if(application_type == "教职工通行码申请") {
        this.staff_passphrase_form_visible = true;
      }
    },
    submitForm(form_name) {
      this.$refs[form_name].validate((valid) =>{
        if(valid) {
          this.$message.success('提交成功!');
        }
        else {
          this.$message.error('表单填写有误，请检查后重新提交!');
          return false;
        }
      });
    }
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