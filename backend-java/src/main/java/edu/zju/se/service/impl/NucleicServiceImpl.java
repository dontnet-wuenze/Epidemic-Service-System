package edu.zju.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import edu.zju.se.entity.Nucleic;
import edu.zju.se.mapper.NucleicMapper;
import edu.zju.se.service.INucleicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Override public Nucleic getResult(String userId) {
    try {
      LambdaQueryChainWrapper<Nucleic> queryWrapper = new LambdaQueryChainWrapper<>(getBaseMapper());
      return queryWrapper.eq(Nucleic::getStaffId, userId).list().get(0);
    } catch (Exception e) {
      throw new RuntimeException("No Result!");
    }
  }

  @Override public void postResult(List<Nucleic> resultList) {
    LambdaUpdateChainWrapper<Nucleic> updateWrapper = new LambdaUpdateChainWrapper<>(getBaseMapper());
    for (Nucleic res : resultList) {
      updateWrapper.eq(Nucleic::getStaffId, res.getStaffId())
          .set(Nucleic::getResult, res.getResult())
          .set(Nucleic::getAppDate, res.getAppDate())
          .update();
    }
  }
}
