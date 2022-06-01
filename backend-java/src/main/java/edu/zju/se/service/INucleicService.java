package edu.zju.se.service;

import edu.zju.se.entity.Nucleic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-29
 */
public interface INucleicService extends IService<Nucleic> {
  public long getNewFormId(String userId);

  public void postNewForm(Nucleic nucleicForm);
}
