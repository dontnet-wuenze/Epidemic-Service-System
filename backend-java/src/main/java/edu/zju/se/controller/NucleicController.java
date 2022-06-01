package edu.zju.se.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.zju.se.common.Result;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.service.INucleicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/nucleic")
public class NucleicController {
  @Autowired
  INucleicService nucleicService;

  @GetMapping("/appointment")
  public Result getAppointmentNumber(@RequestHeader("token") String userId) {
    try {
      long formId = nucleicService.getNewFormId(userId);
      return Result.success(new HashMap<String, Long>(){{put("form_id", formId);}});
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @PostMapping("/appointment")
  public Result postAppointment(@Validated @RequestBody Nucleic nucleicAppointment) {
    try {
      nucleicService.postNewForm(nucleicAppointment);
      return Result.success();
    } catch (RuntimeException e) {
      return Result.fail(e.getMessage());
    }
  }

  @GetMapping("/result")
  public Result getResult(@RequestHeader("token") String userId) {
    return Result.success(nucleicService.list());
  }

}
