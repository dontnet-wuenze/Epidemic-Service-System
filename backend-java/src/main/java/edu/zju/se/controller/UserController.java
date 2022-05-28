package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.User;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
  @GetMapping("/userlist")
  public Result getInfoById(@RequestHeader("token") String id) {
    User user = userService.getUserInfoById(id);
    if (user == null) {
      return Result.fail("NoSuchID");
    }
    return Result.success(user);
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
//  @PostMapping("/login")
//  public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
//
//    User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
//    Assert.notNull(user, "用户不存在");
//
//    if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
//      return Result.fail("密码不正确");
//    }
//    String jwt = jwtUtils.generateToken(user.getId());
//
//    response.setHeader("Authorization", jwt);
//    response.setHeader("Access-control-Expose-Headers", "Authorization");
//
//    return Result.success(MapUtil.()
//            .put("id", user.getId())
//            .put("username", user.getUsername())
//            .put("avatar", user.getAvatar())
//            .put("email", user.getEmail())
//            .map()
//    );
//  }
}