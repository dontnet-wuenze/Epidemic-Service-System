package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.zju.se.common.Result;
import edu.zju.se.entity.GetPost;
import edu.zju.se.entity.Message;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMessageService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  IUserService userService;
  @Autowired
  IMessageService msgService;
  @GetMapping("/userlist")
  public Result getInfoById(@RequestHeader("token") String id) {
    User user = userService.getUserInfoById(id);
    if (user == null) {
      return Result.fail("NoSuchID");
    }
    return Result.success(user);
  }

  @GetMapping("/notice")
  public Result getMsgList(@RequestHeader("token") String userid){
    QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("userid", userid);
    List<Message> result = msgService.list(queryWrapper);
    if(result.isEmpty()){
      return Result.fail("This user has no message.");
    }else{
      return Result.success(result);
    }
  }

  @PostMapping("/signup")
  public Result register(@Validated @RequestBody User user) {
    boolean isSignUpSuccess = userService.signUp(user);
    if (isSignUpSuccess) {
      return Result.success();
    } else {
      return Result.fail();
    }
  }

  @PostMapping("/login")
  public Result login(@Validated @RequestBody User user) {
    boolean isLoginSuccess = userService.login(user);

    if (isLoginSuccess) {
      return Result.success();
    } else {
      return Result.fail();
    }
  }

  @PostMapping("/noticeread")
  public Result noticeRead(@RequestHeader("token") String userid, @Validated @RequestBody GetPost getPost){
    return msgService.MsgRead(userid, getPost);
  }
}