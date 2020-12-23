package com.jpeony.redis.hash;

import com.alibaba.fastjson.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;
/**
 * Redis操作Hash
 *
 * @author yihonglei
 * @date 2019-05-27 12:03
 */
public class HashRedisUtil {

	private static final Charset utf8 = Charset.forName("utf8");

	public static String hget(RedisTemplate<String, String> redis, final String hkey, final String key) {
		return redis.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] bytes = connection.hGet(hkey.getBytes(utf8), key.getBytes(utf8));
				if (null != bytes) {
					return new String(bytes);
				}
				return null;
			}
		});
	}
	public static List<String> hKeys(RedisTemplate<String, String> redis, final String hkey) {
		return redis.execute(new RedisCallback<List<String>>() {

			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				List<String> list=new ArrayList<String>();
				Set<byte[]> bList = connection.hKeys(hkey.getBytes(utf8));
				for (byte[] bs : bList) {
					list.add(new String(bs));
				}
				return list;
			}
		});
	}
	public static List<String> hVals(RedisTemplate<String, String> redis, final String hkey) {
		return redis.execute(new RedisCallback<List<String>>() {

			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				List<String> list=new ArrayList<String>();
				List<byte[]> bList = connection.hVals(hkey.getBytes(utf8));
				for (byte[] bs : bList) {
					list.add(new String(bs));
				}
				return list;
			}
		});
	}
	public static Map<String,String> hgetall(RedisTemplate<String, String> redis, final String hkey) {
		return redis.execute(new RedisCallback<Map<String,String>>() {

			@Override
			public Map<String,String> doInRedis(RedisConnection connection) throws DataAccessException {
				Map<String,String> returnMap=new HashMap<String,String>();
				Map<byte[],byte[]> mapbytes = connection.hGetAll(hkey.getBytes(utf8));

				for(byte[] bt : mapbytes.keySet()){
					byte[] btValue=mapbytes.get(bt);
					returnMap.put(new String(bt), new String(btValue));
				}
				return returnMap;
			}
		});
	}

	public static <T> T hgetall(RedisTemplate<String, String> redis, final String hkey, final Class<T> cls) {
		return redis.execute(new RedisCallback<T>() {

			@Override
			public T doInRedis(RedisConnection connection) throws DataAccessException {
				Map<String, String> returnMap = new HashMap<String, String>();
				Map<byte[],byte[]> mapbytes = connection.hGetAll(hkey.getBytes(utf8));

				for(byte[] bt : mapbytes.keySet()){
					byte[] btValue = mapbytes.get(bt);
					returnMap.put(new String(bt), new String(btValue));
				}
				T t = JSONObject.parseObject(JSONObject.toJSONString(returnMap), cls);
				return t;
			}
		});
	}

	public static String jhget(RedisTemplate<String, String> redis, final String hkey, final String key) {
		return redis.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] bytes = connection.hGet(hkey.getBytes(utf8), key.getBytes(utf8));
				if (null != bytes) {
					return new JdkSerializationRedisSerializer().deserialize(bytes).toString();
				}
				return null;
			}
		});
	}

	public static boolean hset(RedisTemplate<String, String> redis, final String hkey, final String key, final String value) {
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean b = connection.hSet(hkey.getBytes(utf8), key.getBytes(utf8), value.getBytes(utf8));
				return b;
			}
		});
	}

	public static boolean hmset(RedisTemplate<String, String> redis, final String hkey, final Map<String, Object> map) {
		final Map<byte[], byte[]> rMap = new HashMap<byte[], byte[]>();
		for (String key : map.keySet()) {
			Object value = map.get(key);

				String v = null == value ? "" : value.toString();
				rMap.put(key.getBytes(utf8), v.getBytes(utf8));

		}
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				if (rMap.size()>0) {
					connection.hMSet(hkey.getBytes(utf8), rMap);
				}
				return true;
			}
		});
	}
	/**
	 * hashObject加
	 * @param redis
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 */
	public static BigDecimal hincr(RedisTemplate<String, String> redis, final String hkey, final String key, final Object value) {
		return redis.execute(new RedisCallback<BigDecimal>() {

			@Override
			public BigDecimal doInRedis(RedisConnection connection) throws DataAccessException {
				long valOut = 0L;
				valOut = (Long) connection.execute("HINCRBY", hkey.getBytes(utf8), key.getBytes(utf8),
						value.toString().getBytes(utf8));
				return new BigDecimal(valOut);
			}
		});
	}

	public static Long hincrByLong(RedisTemplate<String, String> redis, final String hkey, final String key, final Object value) {
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				Long valOut = 0L;
				valOut = (Long) connection.execute("HINCRBY", hkey.getBytes(utf8), key.getBytes(utf8),
						value.toString().getBytes(utf8));
				return valOut;
			}
		});
	}


	public static BigDecimal hincrByFloat(RedisTemplate<String, String> redis, final String hkey, final String key, final Object value) {
		double valueIn = Double.parseDouble(value.toString());
		double valueOut = redis.opsForHash().increment(hkey, key, valueIn);
		return new BigDecimal(valueOut);
	}

	public static boolean jhset(RedisTemplate<String, String> redis, final String hkey, final String key, final String value) {
		return redis.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean b = connection.hSet(hkey.getBytes(utf8), key.getBytes(utf8), new JdkSerializationRedisSerializer().serialize(value));
				return b;
			}
		});
	}

	public static long hdel(RedisTemplate<String, String> redis, final String hkey, final String key) {
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				long l = connection.hDel(hkey.getBytes(utf8), key.getBytes(utf8));
				return l;
			}
		});
	}

	public static long del(RedisTemplate<String, String> redis, final String... keys) {
		return redis.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {

				long s = 0;
				for (String key : keys) {
					long l = connection.del(key.getBytes(utf8));
					s += l;
				}
				return s;
			}
		});
	}
}
