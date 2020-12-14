package com.jpeony.redis.str;

import com.jpeony.redis.AbstractSimpleTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.testng.annotations.Test;

/**
 * Redis操作String测试
 *
 * @author yihonglei
 */
public class StrTest extends AbstractSimpleTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    private void testSet() {
        String key = "lanhuigu-set";
        String value = "1000";

        Boolean setResult = StrRedisUtil.set(redisTemplate, key, value);

        System.out.println("setResult：" + setResult);
    }

    @Test
    private void testGet() {
        String key = "lanhuigu-set";
        String value = StrRedisUtil.get(redisTemplate, key);
        System.out.println("value：" + value);
    }

}
