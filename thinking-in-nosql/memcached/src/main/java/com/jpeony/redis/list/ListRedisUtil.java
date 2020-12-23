package com.jpeony.redis.list;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * Redis操作List
 *
 * @author yihonglei
 * @date 2019-05-27 12:03
 */
public class ListRedisUtil {
    private static final Charset utf8 = Charset.forName("utf8");

    public static final String SEQ_NO = "seqno";

//    public static boolean lpush(RedisTemplate<String, String> redis, final String key, final Object... value) {
//        return redis.execute(new RedisCallback<Boolean>() {
//
//            @Override
//            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                List<byte[]> list = new ArrayList<byte[]>();
//                for (Object object : value) {
//
//                    if (object instanceof String || object instanceof Number || object instanceof Boolean
//                            || object instanceof Character) {
//
//                        list.add(object.toString().getBytes(utf8));
//                    }else{
//                        list.add(JSON.toJSONString(object).getBytes(utf8));
//                    }
//                }
//                byte[][] arr = list.toArray(new byte[list.size()][0]);
//                connection.lPush(key.getBytes(utf8), arr);
//                return true;
//            }
//        });
//    }

    public static boolean lpush(RedisTemplate<String, String> redis, final String key, final Object... value) {
        return redis.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                List<byte[]> list = new ArrayList<byte[]>();
                for (Object object : value) {

                    if (object instanceof String || object instanceof Number || object instanceof Boolean
                            || object instanceof Character) {
                        list.add(object.toString().getBytes(utf8));
                    }else{
                        list.add(JSON.toJSONString(object).getBytes(utf8));
                    }
                }
                byte[][] arr = list.toArray(new byte[list.size()][0]);
                connection.lPush(key.getBytes(utf8), arr);
                return true;
            }
        });
    }

    public static boolean lpushLimit(RedisTemplate<String, String> redis, final String key, final long limit, final Object... value) {
        return redis.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                List<byte[]> list = new ArrayList<byte[]>();
                for (Object object : value) {
                    if (object instanceof String || object instanceof Number || object instanceof Boolean
                            || object instanceof Character) {
                        list.add(JSON.toJSONString(object).getBytes(utf8));
                    }else{
                        list.add(object.toString().getBytes(utf8));
                    }
                }
                byte[][] arr = list.toArray(new byte[list.size()][0]);
                connection.lPush(key.getBytes(utf8), arr);
                connection.lTrim(key.getBytes(utf8), 0,limit-1);
                return true;
            }
        });
    }

    public static String rpop(RedisTemplate<String, String> redis,final String key){
        return redis.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte [] data =connection.rPop(key.getBytes(utf8));
                if (data == null) {
                    return null;
                }
                return new String(data, utf8);
            }
        });
    }

    public static String lpop(RedisTemplate<String, String> redis,final String key){
        return redis.execute(new RedisCallback<String>() {

            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte [] data =connection.lPop(key.getBytes(utf8));
                if (data == null) {
                    return null;
                }
                return new String(data, utf8);
            }
        });
    }

}
