package com.jpeony.sharding.jdbc.service.user;

import com.jpeony.sharding.jdbc.mapper.UserMapper;
import com.jpeony.sharding.jdbc.pojo.User;
import com.jpeony.sharding.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

}
