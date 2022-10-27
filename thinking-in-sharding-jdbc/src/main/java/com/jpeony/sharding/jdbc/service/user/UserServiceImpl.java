package com.jpeony.sharding.jdbc.service.user;

import com.jpeony.sharding.jdbc.mapper.UserMapper;
import com.jpeony.sharding.jdbc.pojo.User;
import com.jpeony.sharding.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yihonglei
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return null;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }
}
