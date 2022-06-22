package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.zju.se.common.Result;
import edu.zju.se.entity.GetPost;
import edu.zju.se.entity.Message;
import edu.zju.se.entity.Punch;
import edu.zju.se.entity.User;
import edu.zju.se.service.IMessageService;
import edu.zju.se.service.IPunchService;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
  @Autowired
  IPunchService punchService;

  @GetMapping("/userinfo")
  public Result getInfoById(@RequestHeader("token") String id) {
    User user = userService.getUserInfoById(id);
    if (user == null) {
      return Result.fail("NoSuchID");
    }
    return Result.success(user);
  }

  @GetMapping("/userlist")
  public Result getAllUsers() {
    List<User> userList = userService.list();
    if (userList == null) {
      return Result.fail(500, "Internal Error", null);
    }
    return Result.success(userList);
  }

  @GetMapping("/notice")
  public Result getMsgList(@RequestHeader("token") String userid){
    QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("userid", userid);
    List<Message> result = msgService.list(queryWrapper);
    return Result.success(result);
  }

  @GetMapping("/code")
  public Result getCode(@RequestHeader("token") String userid){
    User user = userService.getById(userid);
    if(user == null){
      return Result.fail("No such ID");
    }else{
      return Result.success(userService.GetCode(userid));
    }
  }

  @GetMapping("/attend")
  public Result getPunch(@RequestHeader("token") String id){
    User user = userService.getById(id);
    if(user == null){
      return Result.fail("No such ID");
    }else{
      return Result.success(punchService.GetPunch(id));
    }
  }

  @PostMapping("/attend")
  public Result attendPunch(@Validated @RequestBody Punch punch) {
//    System.out.print(punch.getDate());
    Punch punch1 = punchService.getById(punch.getId());
    if(punch1 == null){
      return Result.fail("No such ID");
    }else{
      UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
      userUpdateWrapper.eq("id", punch.getId())
              .set("attend", true);
      userService.update(userUpdateWrapper);
      boolean isUpdateSuccess = punchService.AttendPunch(punch);
      if (isUpdateSuccess) {
        return Result.success();
      } else {
        return Result.fail();
      }
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
  public Result login(@Validated @RequestBody User tempUser) {
    boolean isLoginSuccess = userService.login(tempUser);

    try {
      if (isLoginSuccess) {
        User user = userService.getUserInfoById(tempUser.getId());
        return Result.success(
            new HashMap<String, Object>() {{
              put("token", user.getId());
              put("name", user.getName());
              put("authorization", "admin".equals(user.getPermission()));
            }}
        );
      } else {
        return Result.fail("Login Failed");
      }
    } catch (Exception e) {
      System.out.println("in error");
      return Result.fail("Login Failed");
    }
  }

  @PostMapping("/noticeread")
//  public Result noticeRead(@RequestHeader("token") String userid, @Validated @RequestBody GetPost getPost){
  public Result noticeRead(@RequestHeader("token") String userid, @Validated @RequestParam("msgid") List readList){
    return msgService.MsgRead(userid, readList);
//    return msgService.MsgRead(userid, getPost);
  }
}
