package edu.zju.se.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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

  @Test void testGetForm() throws JsonProcessingException {
    formController.getForm("3190102303", "11111111");
  }

  @Test void testGetUserFormList() throws JsonProcessingException {
    testGetForm();
  }

  @Test void testGetApprovalFormList() throws JsonProcessingException {
    testGetForm();
  }
}