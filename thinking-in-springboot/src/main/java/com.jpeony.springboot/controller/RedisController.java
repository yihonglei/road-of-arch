package com.jpeony.springboot.controller;

import com.jpeony.springboot.util.StrRedisUtil;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot整合Redis
 *
 * @author yihonglei
 */
@RestController
public class RedisController {

    @Autowired
    RedisTemplate<String, String> redis;

    @RequestMapping(value = "/testRedis")
    public String queryUser(@RequestParam("phone") String phone) {
        // 根据手机号从缓存获取用户，获取到直接返回，否则去查库
        String userObj = StrRedisUtil.get(redis, phone);

        // 如果从缓存拿到用户，直接返回
        if (!StringUtils.isEmpty(userObj)) {

            return userObj + "[from redis]";
        }

        // 如果从缓存获取不到，就从数据库获取
        userObj = "用户对象"; // 根据手机号从数据库获取

        // 并且把从数据库获取的用户对象存入缓存
        StrRedisUtil.set(redis, phone, userObj);

        return userObj;
    }

}
