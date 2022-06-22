package edu.zju.se.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.Form;
import edu.zju.se.entity.User;
import edu.zju.se.service.IFormService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum FormType {
  学生离校申请("stu_leave_form"),
  学生通行码申请("stu_passphrase_form"),
  教职工离校申请("staff_leave_form"),
  教职工通行码申请("staff_passphrase_form");

  private final String formType;
  FormType(String formType) {
    this.formType = formType;
  }
}

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-03
 */
@RestController
@RequestMapping("/apply")
public class FormController {
  @Autowired
  IFormService formService;

  @Autowired
  IUserService userService;

  @GetMapping("/get_apply_id")
  public Result getApplyId(@RequestHeader("token") String userId) {
    try {
      String formId = formService.getNewFormId(userId);
      User user = userService.getUserInfoById(userId);
      return Result.success(new HashMap<String, String>(){{
        put("id", formId);
        put("name", user.getName());
        put("staff_id", user.getId());
      }});
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @PostMapping("/stu_leave_form")
  public Result postStudentLeaveForm(@RequestHeader("token") String userId, @RequestBody String rawJson)
      throws JsonProcessingException {
    Form form = new ObjectMapper().readValue(rawJson, Form.class);
    form = Form.builder()
        .formId(form.getFormId())
        .formType(FormType.学生离校申请.name())
        .staffId(userId)
        .content(rawJson)
        .applicationTime(new Date().toString())
        .build();
    try {
      formService.postLeaveForm(form);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @PostMapping("/staff_leave_form")
  public Result postStaffLeaveForm(@RequestHeader("token") String userId, @RequestBody String rawJson)
      throws JsonProcessingException {
    Form form = new ObjectMapper().readValue(rawJson, Form.class);
    form = Form.builder()
        .formId(form.getFormId())
        .formType(FormType.教职工离校申请.name())
        .staffId(userId)
        .content(rawJson)
        .applicationTime(new Date().toString())
        .build();
    try {
      formService.postLeaveForm(form);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @PostMapping("/stu_passphrase_form")
  public Result postStudentPassPhraseForm(@RequestHeader("token") String userId, @RequestBody String rawJson)
      throws JsonProcessingException {
    Form form = new ObjectMapper().readValue(rawJson, Form.class);
    form = Form.builder()
        .formId(form.getFormId())
        .formType(FormType.学生通行码申请.name())
        .staffId(userId)
        .auditId(form.getAuditId())
        .content(rawJson)
        .applicationTime(new Date().toString())
        .auditId(userService.getAdminOfStudent(userId).getId())
        .build();
    try {
      formService.postPassPhraseForm(form);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @PostMapping("/staff_passphrase_form")
  public Result postStaffPassPhraseForm(@RequestHeader("token") String userId, @RequestBody String rawJson)
      throws JsonProcessingException {
    Form form = new ObjectMapper().readValue(rawJson, Form.class);
    form = Form.builder()
        .formId(form.getFormId())
        .formType(FormType.教职工通行码申请.name())
        .staffId(userId)
        .auditId(form.getAuditId())
        .content(rawJson)
        .applicationTime(new Date().toString())
        .auditId(userService.getAdminOfStudent(userId).getId())
        .build();
    try {
      formService.postPassPhraseForm(form);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @GetMapping({"/get_staff_passphrase_form", "/get_stu_passphrase_form", "/get_staff_leave_form", "/get_stu_leave_form"})
  public Result getForm(@RequestHeader("token") String userId, @RequestBody Form form) {
    return Result.success(formService.getForm(form.getFormId()));
  }

  @GetMapping("/get_application_log")
  public Result getUserFormList(@RequestHeader("token") String userId) {
    List<Form> formList = formService.getUserForm(userId);
    List<Map<String, String>> resultList = new ArrayList<>();
    User user = userService.getUserInfoById(userId);
    for (Form form : formList) {
      resultList.add(new HashMap<String, String>(){{
        put("applicant", user.getName());
        put("application_time", form.getApplicationTime());
        put("application_type", form.getFormType());
        put("audit_status", form.getStatus());
      }});
    }
    return Result.success(resultList);
  }

@GetMapping("/get_form_approval_list")
  public Result getApprovalFormList(@RequestHeader("token") String userId) {
    List<Form> formList = formService.getApprovalForm(userId);
    List<Map<String, String>> resultList = new ArrayList<>();
    for (Form form : formList) {
      User user = userService.getUserInfoById(form.getStaffId());
      resultList.add(new HashMap<String, String>(){{
        put("id", form.getFormId());
        put("applicant", user.getName());
        put("application_time", form.getApplicationTime());
        put("application_type", form.getFormType());
        put("approval_status", form.getStatus());
      }});
    }
    return Result.success(resultList);
  }


}
