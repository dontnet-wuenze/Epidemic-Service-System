package edu.zju.se.service;

import edu.zju.se.entity.Nucleic;
import edu.zju.se.entity.Punch;
import edu.zju.se.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-20
 */
public interface IUserService extends IService<User> {
  User getUserInfoById(String id);

  boolean signUp(User user);

  boolean login(User user);

  User GetCode(String userid);

  void setNucleicTrue(List<Nucleic> resultList);

  User getAdminOfStudent(String stu_id);

}
