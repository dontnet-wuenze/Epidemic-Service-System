package edu.zju.se.service;

import edu.zju.se.entity.Nucleic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-29
 */
public interface INucleicService extends IService<Nucleic> {
  public String getNewFormId(String userId);
  public void postNewForm(Nucleic nucleicForm);
  public Nucleic getResult(String userId);
  public void postResult(List<Nucleic> resultList);
}
