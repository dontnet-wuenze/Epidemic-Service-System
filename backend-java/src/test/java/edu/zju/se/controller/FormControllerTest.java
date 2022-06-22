package edu.zju.se.controller;

import edu.zju.se.entity.Form;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FormControllerTest {

  @Resource
  private FormController formController;

  @Test void testGetApplyId() {
    formController.getApplyId("3190102303");
  }

  @Test void testGetForm() {
    formController.getForm("3190102303", "11111111");
  }

  @Test void testGetUserFormList() {
    testGetForm();
  }

  @Test void testGetApprovalFormList() {
    testGetForm();
  }
}