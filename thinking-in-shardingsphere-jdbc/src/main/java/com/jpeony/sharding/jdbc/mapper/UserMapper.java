package com.jpeony.sharding.jdbc.mapper;

import com.jpeony.sharding.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 微信公众号：微观技术
 */

@Mapper
public interface UserMapper {

    Long addUser(User user);

    List<User> queryAllUser();

    User queryUserById(int id);
}