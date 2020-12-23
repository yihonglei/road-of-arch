package com.jpeony.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * Jedis快速入门
 *
 * @author yihonglei
 */
public class SimpleJedis {
    public static void main(String[] args) {
        // 建立连接
        Jedis jedis = new Jedis("localhost", 6379);

        // 密码授权
        jedis.auth("redis_password");

        // set操作
        jedis.set("lanhuigu", "2019");

        // get操作
        String str = jedis.get("lanhuigu");

        // 打印get结果
        System.out.println("Jedis Simple Demo：" + str);
    }
}