package edu.zju.se.controller;

import edu.zju.se.entity.Nucleic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NucleicControllerTest {

  @Resource
  private NucleicController nucleicController;

  @Test void testGetAppointmentNumber() {
    nucleicController.getAppointmentNumber("3190102303");
  }

  @Test void testPostAppointment() {
    nucleicController.postAppointment(Nucleic.builder().build());
  }

  @Test void testGetResult() {
    nucleicController.getResult("3190102303");
  }

  @Test void testUploadResult() {
    testPostAppointment();
  }
}