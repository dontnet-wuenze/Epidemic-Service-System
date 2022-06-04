package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import edu.zju.se.entity.Form;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.entity.User;
import edu.zju.se.mapper.FormMapper;
import edu.zju.se.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-03
 */
@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements IFormService {

  @Override
  public String getNewFormId(String userId) {
    Form form = Form.builder()
        .staffId(userId)
        .build();
    if (save(form)) {
      return form.getFormId();
    } else {
      throw new RuntimeException("Failed to generate an unique form_id, please try again!");
    }
  }
  @Override public void postLeaveForm(Form form) {
    IUserService userService = new UserServiceImpl();
    LambdaUpdateChainWrapper<User> updateWrapper = new LambdaUpdateChainWrapper<>(userService.getBaseMapper());
    updateWrapper.eq(User::getId, form.getStaffId())
        .set(User::getCode, "1")
        .update();
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
  }

  @Override public void postPassPhraseForm(Form form) {
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
  }

  @Override public Form getForm(String form_id) {
    try {
      return getById(form_id);
    } catch (Exception e) {
      throw new RuntimeException("No Result!");
    }
  }

}
