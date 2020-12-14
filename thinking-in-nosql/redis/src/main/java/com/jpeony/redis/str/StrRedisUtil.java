package com.jpeony.redis.str;

import com.alibaba.fastjson.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.Charset;
/**
 * Redis操作String
 *
 * @author yihonglei
 * @date 2019-05-27 12:02
 */
public class StrRedisUtil {

	private static final Charset UTF8CHARSET=Charset.forName("utf8");
	public static boolean setnx(RedisTemplate<String, String> redis, final String key, final String value) {
		return redis.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.setNX(key.getBytes(UTF8CHARSET), value.getBytes(UTF8CHARSET));
			}
		});
	}

	public static boolean set(RedisTemplate<String, String> redis,final String key,final Object value){
		String v;
		if (value instanceof String) {
			v=value.toString();
		}else{
			v=JSONObject.toJSONString(value);
		}
		final String json=v;
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {

				connection.set(key.getBytes(UTF8CHARSET), json.getBytes(UTF8CHARSET));
				return true;
			}

		});
	}

	public static String get(RedisTemplate<String, String> redis,final String key){
		return redis.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte [] data =connection.get(key.getBytes(UTF8CHARSET));
				if (data == null) {
					return null;
				}
				return new String(data, UTF8CHARSET);
			}
		});
	}

	public static <T> T get(RedisTemplate<String, String> redis,final String key, final Class<T> tClass){
		return redis.execute(new RedisCallback<T>() {
			@Override
			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte [] data =connection.get(key.getBytes(UTF8CHARSET));
				if (data == null) {
					return null;
				}
				if(!String.class.getSimpleName().equals(tClass.getSimpleName())) {
					return JSONObject.parseObject(data, tClass);
				} else {
					return (T) new String(data, UTF8CHARSET);
				}
			}
		});
	}

	public static boolean setEx(RedisTemplate<String, String> redis,final String key,final int expire,final Object value){
		String v;
		if (value instanceof String) {
			v=value.toString();
		}else{
			v=JSONObject.toJSONString(value);
		}
		final String json=v;
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

	public static Boolean exists(RedisTemplate<String, String> redis,final String key){
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.exists(key.getBytes(UTF8CHARSET));
			}
		});
	}

	public static Long del(RedisTemplate<String, String> redis,final String key){
		return redis.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.del(key.getBytes(UTF8CHARSET));
			}
		});
	}

	public static Long incr(RedisTemplate<String, String> redis,final String key){
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.incr(key.getBytes(UTF8CHARSET));
			}
		});
	}

	public static Boolean expire(RedisTemplate<String, String> redis, final String key, final long timeout) {
		return redis.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.expire(key.getBytes(UTF8CHARSET), timeout);
			}
		});
	}
}
