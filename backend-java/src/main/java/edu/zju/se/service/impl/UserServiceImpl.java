package edu.zju.se.service.impl;

import edu.zju.se.entity.User;
import edu.zju.se.mapper.UserMapper;
import edu.zju.se.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
