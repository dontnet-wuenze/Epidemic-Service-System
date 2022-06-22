package edu.zju.se.controller;

import edu.zju.se.common.Result;
import edu.zju.se.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
  @Resource
  private UserController userController;
  @Test void testGetInfoById() {
    userController.getInfoById("3190102303");
  }

  @Test void testGetAllUsers() {
    userController.getAllUsers();
  }

  @Test void testGetCode() {
    userController.getCode("3190102303");
  }

  @Test void testGetPunch() {
    userController.getPunch("3190102303");
  }

  @Test void testRegister() {
    User user = User.builder()
        .id("3190102304")
        .password("123456")
        .permission("student")
        .build();
    Result result = userController.register(user);
    Assertions.assertEquals(200, result.getCode());
  }

  @Test void testLogin() {
    User user = User.builder()
        .id("3190102303")
        .permission("student")
        .password("123456")
        .build();
    userController.register(user);
    Result result = userController.login(user);
    Assertions.assertEquals(200, result.getCode());

    user.setPassword("12345");
    result = userController.login(user);
    Assertions.assertEquals(400, result.getCode());
  }
}

