package edu.zju.se.mapper;

import edu.zju.se.entity.User;
import edu.zju.se.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserMapperTest {
  @Resource
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assertions.assertEquals(1, userList.size());
    userList.forEach(System.out::println);
  }

  @Test
  public void testInsert() {
    System.out.println(("----- Insert method test ------"));
    User user = new User();
    user.setId("testId");
    user.setPassword("123456");
    userMapper.insert(user);
    List<User> userList = userMapper.selectList(null);
    Assertions.assertEquals(2, userList.size());
    userList.forEach(System.out::println);
  }
}