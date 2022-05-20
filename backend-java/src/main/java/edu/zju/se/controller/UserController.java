package edu.zju.se.controller;

import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  @GetMapping("/{id}")
  public Object test(@PathVariable("id") Long id) {
    return userService.getById(id);
  }
}