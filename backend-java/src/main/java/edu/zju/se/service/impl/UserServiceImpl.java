package edu.zju.se.service.impl;

import edu.zju.se.entity.User;
import edu.zju.se.mapper.UserMapper;
import edu.zju.se.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
