package com.jpeony.sharding.jdbc.service;

import com.jpeony.sharding.jdbc.pojo.User;

import java.util.List;

/**
 * @author yihonglei
 */
public interface UserService {
    Long addUser(User user);

    List<User> queryAllUser();

    User queryUserById(Long id);
}
