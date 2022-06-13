package edu.zju.se.controller;

import edu.zju.se.common.Result;
import edu.zju.se.entity.Message;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMessageService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService msgService;
    @Autowired
    IUserService userService;
    @PostMapping
    public Result sendMsg(@Validated @RequestBody Message msg){
        User user = userService.getById(msg.getUserid());
        if(user == null){
            return Result.fail("No such ID!");
        } else{
            boolean isSent = msgService.SendMsg(msg);
            if(isSent) {
                return Result.success("The message has been sent.");
            } else{
                return Result.fail("The msgid already exists!");
            }
        }
    }
}
