package edu.zju.se.controller;

import edu.zju.se.common.Result;
import edu.zju.se.entity.Message;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMessageService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService msgService;
    @Autowired
    IUserService userService;
    @PostMapping("/sendnotice")
    public Result sendMsg(@Validated @RequestBody List<Message> msg){
        for (int i=0; i<msg.size(); i++) {
            User user = userService.getById(msg.get(i).getUserid());
            if (user == null) {
                return Result.fail("No such ID!");
            } else {
                boolean isSent = msgService.SendMsg(msg.get(i));
//                if (isSent) {
//                    return Result.success("The message has been sent.");
//                } else {
//                    return Result.fail("The msgid already exists!");
//                }
            }
        }
        return Result.success("The message has been sent.");
    }
}
