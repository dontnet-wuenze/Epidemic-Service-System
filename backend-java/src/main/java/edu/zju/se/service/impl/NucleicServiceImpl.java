package edu.zju.se.service.impl;

import edu.zju.se.entity.Nucleic;
import edu.zju.se.mapper.NucleicMapper;
import edu.zju.se.service.INucleicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-29
 */
@Service
public class NucleicServiceImpl extends ServiceImpl<NucleicMapper, Nucleic> implements INucleicService {

  @Override
  public long getNewFormId(String userId) {
    Nucleic nucleic = Nucleic.builder()
        .staffId(userId)
        .build();
    if (save(nucleic)) {
      return nucleic.getFormId();
    } else {
      throw new RuntimeException("Failed to generate an unique form_id, please try again!");
    }
  }

  @Override public void postNewForm(Nucleic nucleicForm) {
    if (!updateById(nucleicForm)) {
      throw new RuntimeException("Provided form_id is invalid, please try again!");
    }
  }
}
