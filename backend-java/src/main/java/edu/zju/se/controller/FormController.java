package edu.zju.se.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.Form;
import edu.zju.se.entity.User;
import edu.zju.se.service.IFormService;
import edu.zju.se.service.IUserService;
import edu.zju.se.service.impl.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

enum FormType {
  STU_LEAVE_FORM("stu_leave_form"),
  STU_PASSPHRASE_FORM("stu_passphrase_form"),
  STAFF_LEAVE_FORM("staff_leave_form"),
  STAFF_PASSPHRASE_FORM("staff_passphrase_form");

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
        .formType(FormType.STU_LEAVE_FORM.name())
        .staffId(userId)
        .content(rawJson)
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
        .formType(FormType.STAFF_LEAVE_FORM.name())
        .staffId(userId)
        .content(rawJson)
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
        .formType(FormType.STU_PASSPHRASE_FORM.name())
        .staffId(userId)
        .auditId(form.getAuditId())
        .content(rawJson)
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
        .formType(FormType.STAFF_PASSPHRASE_FORM.name())
        .staffId(userId)
        .auditId(form.getAuditId())
        .content(rawJson)
        .build();
    try {
      formService.postPassPhraseForm(form);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @GetMapping({"/get_staff_passphrase_form", "get_stu_passphrase_form", "get_staff_leave_form", "get_stu_leave_form"})
  public Result getForm(@RequestHeader("token") String userId, @RequestBody Form form) {
    return Result.success(formService.getForm(form.getFormId()));
  }

}
