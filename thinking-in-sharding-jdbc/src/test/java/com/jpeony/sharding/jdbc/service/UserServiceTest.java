package com.jpeony.sharding.jdbc.service;

import com.jpeony.sharding.jdbc.BaseServletTest;
import com.jpeony.sharding.jdbc.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yihonglei
 */
@Slf4j
public class UserServiceTest extends BaseServletTest {
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
}
