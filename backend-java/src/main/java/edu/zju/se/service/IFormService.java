package edu.zju.se.service;

import edu.zju.se.entity.Form;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Boris Li
 * @since 2022-06-03
 */
public interface IFormService extends IService<Form> {
  public String getNewFormId(String userId);
  public void postStudentLeaveForm(Form form);
  public void postStudentPassPhraseForm(Form form);
  public List<Form> getStaffPassPhraseForm(String userId);
}
