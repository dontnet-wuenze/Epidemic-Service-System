package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import edu.zju.se.entity.Form;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.mapper.FormMapper;
import edu.zju.se.service.IFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
  @Override public void postStudentLeaveForm(Form form) {
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
  }

  @Override public void postStudentPassPhraseForm(Form form) {
    if (!updateById(form)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
  }

  @Override public List<Form> getStaffPassPhraseForm(String userId) {
    try {
      LambdaQueryChainWrapper<Form> queryWrapper = new LambdaQueryChainWrapper<>(getBaseMapper());
      return queryWrapper.eq(Form::getStaffId, userId).list();
    } catch (Exception e) {
      throw new RuntimeException("No Result!");
    }
  }

}
