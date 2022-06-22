package edu.zju.se.controller;

import edu.zju.se.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageControllerTest {
  @Resource
  private MessageController messageController;

  @Test void testSendMsg() {
    messageController.sendMsg(Message.builder().build());
  }
}