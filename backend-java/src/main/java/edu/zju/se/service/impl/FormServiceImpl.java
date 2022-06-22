package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import edu.zju.se.entity.Form;
import edu.zju.se.mapper.FormMapper;
import edu.zju.se.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.zju.se.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  IUserService userService;

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
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
    userService.updateCode(form.getStaffId(), "1");
  }

  @Override public void postPassPhraseForm(Form form) {
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
    if ("审核通过".equals(form.getStatus())) {
      userService.updateCode(form.getStaffId(), "0");
    }
  }

  @Override public Form getForm(String form_id) {
    try {
      return getById(form_id);
    } catch (Exception e) {
      throw new RuntimeException("No Result!");
    }
  }

  @Override public List<Form> getUserForm(String userId) {
    LambdaQueryChainWrapper<Form> queryWrapper = new LambdaQueryChainWrapper<>(getBaseMapper());
    return queryWrapper.eq(Form::getStaffId, userId).list();
  }

  @Override public List<Form> getApprovalForm(String userId) {
    LambdaQueryChainWrapper<Form> queryWrapper = new LambdaQueryChainWrapper<>(getBaseMapper());
    return queryWrapper.eq(Form::getAuditId, userId).list();
  }

}
