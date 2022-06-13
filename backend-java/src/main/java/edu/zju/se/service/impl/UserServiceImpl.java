package edu.zju.se.service.impl;

import edu.zju.se.entity.Punch;
import edu.zju.se.entity.User;
import edu.zju.se.mapper.UserMapper;
import edu.zju.se.service.IPunchService;
import edu.zju.se.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Boris Li
 * @since 2022-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

  @Autowired
  IPunchService punchService;
  @Override
  @Nullable
  public User getUserInfoById(String id) {
    User tempUser = getById(id);
    if (tempUser == null) {
      return null;
    }
    return User.builder()
                    .id(tempUser.getId())
                    .name(tempUser.getName())
                    .department(tempUser.getDepartment())
                    .major(tempUser.getMajor())
                    .administrativeclass(tempUser.getAdministrativeclass())
                    .phone(tempUser.getPhone())
                    .build();
  }

  @Override
  public boolean signUp(User user) {
    if (getById(user.getId()) != null) {
      return false;
    } else {
      save(user);
      punchService.save(Punch.builder()
              .id(user.getId())
              .status(false)
              .build());
      return true;
    }
  }

  @Override
  public boolean login(User user) {
    if (getById(user.getId()).getPassword().equals(user.getPassword())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public User GetCode(String userid) {
    User tmpUser=getById(userid);
    return User.builder()
            .name(tmpUser.getName())
            .department(tmpUser.getDepartment())
            .administrativeclass(tmpUser.getAdministrativeclass())
            .code(tmpUser.getCode())
            .build();
  }

}
