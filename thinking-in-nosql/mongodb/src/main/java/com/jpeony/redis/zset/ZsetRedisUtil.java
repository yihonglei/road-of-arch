package com.jpeony.redis.zset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Redis操作zet类型
 *
 * @author yihonglei
 * @date 2019-05-27 12:03
 */
public class ZsetRedisUtil {
	private static final Charset UTF8CHARSET = Charset.forName("utf8");

	public static Boolean zAdd(RedisTemplate<String, String> redis, final String key, final Object value,final double score) {
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				String v=JSON.toJSONString(value);
				return connection.zAdd(key.getBytes(UTF8CHARSET), score, v.getBytes(UTF8CHARSET));
			}
		});
	}

	public static Long zRem(RedisTemplate<String, String> redis, final String key, final Object value) {
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				String v;
				if (value instanceof String) {
					v=JSON.toJSONString(value);
				}else{
					v=value.toString();
				}
				return connection.zRem(key.getBytes(UTF8CHARSET), v.getBytes(UTF8CHARSET));
			}
		});
	}

	public static Long zRemRange(RedisTemplate<String, String> redis, final String key, final int begin, final int end) {
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.zRemRange(key.getBytes(UTF8CHARSET), begin, end);
			}
		});
	}

	public static List<String> zRange(RedisTemplate<String, String> redis, final String key, final int begin, final int end) {
		return redis.execute(new RedisCallback<List<String>>() {

			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {

				Set<byte[]> set =  connection.zRange(key.getBytes(UTF8CHARSET), begin, end);
				List<String> list = new ArrayList<String>();
				for (byte[] arr : set) {
					list.add(new String(arr));
				}
				return list;
			}
		});
	}

	public static List<String> zRevRange(RedisTemplate<String, String> redis, final String key, final int begin, final int end) {
		return redis.execute(new RedisCallback<List<String>>() {

			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {

				Set<byte[]> set =  connection.zRevRange(key.getBytes(UTF8CHARSET), begin, end);
				List<String> list = new ArrayList<String>();
				for (byte[] arr : set) {
					list.add(new String(arr));
				}
				return list;
			}
		});
	}

	public static <T> List<T> zRangeObject(RedisTemplate<String, String> redis, final String key, final int begin, final int end, Class<T> objClass) {
		return redis.execute(new RedisCallback<List<T>>() {

			@Override
			public List<T> doInRedis(RedisConnection connection) throws DataAccessException {

				Set<byte[]> set =  connection.zRange(key.getBytes(UTF8CHARSET), begin, end);
				List<T> list = new ArrayList<>();
				for (byte[] arr : set) {
					list.add(JSONObject.parseObject(new String(arr, UTF8CHARSET), objClass));
				}
				return list;
			}
		});
	}
}
