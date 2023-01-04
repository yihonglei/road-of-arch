package com.jpeony.sharding.jdbc.service;


import com.alibaba.fastjson.JSON;
import com.jpeony.sharding.jdbc.ApiApplication;
import com.jpeony.sharding.jdbc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yihonglei
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        for (long i = 1; i < 11; i++) {
            User user = User.builder().id(i).userName("Tom-" + i).age(29).address("北京").build();
            userService.addUser(user);
            System.out.println("插入用户成功，uid=" + user.getId());
        }
    }

    @Test
    public void testQueryUserById() {
        User user = userService.queryUserById(1);
        System.out.println("查询用户 = " + JSON.toJSONString(user));
    }
}
