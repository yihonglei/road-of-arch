package com.jpeony.springboot.util;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.Charset;

/**
 * redis-String数据结构工具类
 *
 * @author yihonglei
 */
public class StrRedisUtil {
    private static final Charset UTF8CHARSET = Charset.forName("utf8");

    public static boolean setnx(RedisTemplate<String, String> redis, final String key, final String value) {
        return redis.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(key.getBytes(UTF8CHARSET), value.getBytes(UTF8CHARSET));
            }
        });
    }

    public static boolean set(RedisTemplate<String, String> redis, final String key, final Object value) {
        String v = JSON.toJSONString(value);
        final String json = v;
        return redis.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {

                connection.set(key.getBytes(UTF8CHARSET), json.getBytes(UTF8CHARSET));
                return true;
            }

        });
    }

    public static String get(RedisTemplate<String, String> redis, final String key) {
        return redis.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] data = connection.get(key.getBytes(UTF8CHARSET));
                if (data == null) {
                    return null;
                }
                return new String(data, UTF8CHARSET);
            }
        });
    }

    public static boolean setEx(RedisTemplate<String, String> redis, final String key, final long expire, final Object value) {
        String v = JSON.toJSONString(value);
        final String json = v;
        return redis.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.setEx(
                        key.getBytes(UTF8CHARSET),
                        expire, json.getBytes(UTF8CHARSET));
                return true;
            }

        });
    }

    public static Boolean exists(RedisTemplate<String, String> redis, final String key) {
        return redis.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(key.getBytes(UTF8CHARSET));
            }
        });
    }

    public static Long del(RedisTemplate<String, String> redis, final String key) {
        return redis.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(key.getBytes(UTF8CHARSET));
            }
        });
    }

    public static String incr(RedisTemplate<String, String> redis, final String key) {
        return redis.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.incr(key.getBytes(UTF8CHARSET)).toString();
            }
        });
    }

    public static Long hIncrBy(RedisTemplate<String, String> redis, final String Hashkey, final String key, final Long value) {
        return redis.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                Long bytes = connection.hIncrBy(Hashkey.getBytes(UTF8CHARSET), key.getBytes(UTF8CHARSET), value);
                return bytes;
            }
        });
    }

    public static String expire(RedisTemplate<String, String> redis, final String key, final Long seconds) {
        return redis.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.expire(key.getBytes(UTF8CHARSET), seconds).toString();
            }
        });
    }
}