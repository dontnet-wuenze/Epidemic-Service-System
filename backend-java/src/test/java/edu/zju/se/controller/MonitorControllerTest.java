package edu.zju.se.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MonitorControllerTest {

  @Resource
  private MonitorController monitorController;

  @Test void testGetNucleic_All() {
    monitorController.getNucleic_All();
  }

  @Test void testGetCount_All() {
    monitorController.getCount_All();
  }

  @Test void testUnattendList() {
    monitorController.unattendList();
  }

  @Test void testAttendnum() {
    monitorController.attendnum();
  }

}