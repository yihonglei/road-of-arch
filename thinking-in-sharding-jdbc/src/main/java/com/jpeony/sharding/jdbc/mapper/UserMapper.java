package com.jpeony.sharding.jdbc.mapper;

import com.jpeony.sharding.jdbc.pojo.User;

import java.util.List;

public interface UserMapper {

    Long addUser(User user);

    List<User> queryAllUser();

    User queryUserById(Long id);
}