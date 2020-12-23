package com.jpeony.redis.jedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Jedis API操作
 *
 * @author yihonglei
 */
public class JedisApi {
    private static Jedis jedis;
    private static final String KEY = "jedis_api_key";
    private static final String VALUE = "lanhuigu";

    @Before
    public void startJedisConn() {
        jedis = new Jedis("localhost", 6379);
        jedis.auth("redis_password");
    }

    /**
     * 基本操作
     */
    @Test
    public void testKey() {
        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("新增一个键值对：" + jedis.set(KEY, VALUE));
        System.out.println("判断键是否存在：" + jedis.exists(KEY));

        Set<String> keys = jedis.keys("*");

        System.out.println("系统中所有的键：" + keys);
        System.out.println("查看键存储的数据类型：" + jedis.type(KEY));
        System.out.println("删除键值：" + jedis.del(KEY));
    }

    /**
     * ttl：键值剩余存活时间【秒】
     * pttl：键值剩余存活时间【毫秒】
     */
    @Test
    public void testTtlAndPttl() throws InterruptedException {
        // 清空数据
        System.out.println("清空数据：" + jedis.flushDB());

        // 设置键值，超时时间为10秒
        System.out.println("设置键值，超时时间为10秒：" + jedis.setex(KEY, 10, VALUE));

        // 休眠2秒
        Thread.sleep(2000);

        // 获取剩余存活时间
        long ttl = jedis.ttl(KEY);
        long pttl = jedis.pttl(KEY); // 这里应该不到8000毫秒，获取过程耗时几毫秒！

        System.out.println("键值剩余存活时间【秒】:" + ttl);
        System.out.println("键值剩余存活时间【毫秒】:" + pttl);
    }

    /**
     * expire：设置键值超时时间，超时过期自动清除
     */
    @Test
    public void testExpire() throws InterruptedException {
        // 清空数据
        System.out.println("清空数据：" + jedis.flushDB());

        // set数据
        System.out.println("set键值对：" + jedis.set(KEY, VALUE));

        // 设置键值超时时间
        System.out.println("设置key的超时时间：" + jedis.expire(KEY, 10));

        // 休眠5秒，key没有过期，能获取到值
        Thread.sleep(5000);
        System.out.println("key未过期，能够获取值:" + jedis.get(KEY));

        // 再休眠6秒，key过期，获取不到值
        Thread.sleep(6000);
        System.out.println("key过期，获取不到值:" + jedis.get(KEY));
    }

    /**
     * type：获取键值存储数据类型
     */
    @Test
    public void testType() {
        // 清空数据
        System.out.println("清空数据：" + jedis.flushDB());

        // set数据
        System.out.println("set键值对：" + jedis.set(KEY, VALUE));

        // 获取键值存储数据类型
        System.out.println("数据类型：" + jedis.type(KEY));
    }

    /**
     * exists：判断数据是否存在
     */
    @Test
    public void testExists() {
        // 清空数据
        System.out.println("清空数据：" + jedis.flushDB());

        // set数据
        System.out.println("set键值对：" + jedis.set(KEY, VALUE));

        // 判断数据是否存在
        System.out.println("判断Key是否存在:" + jedis.exists(KEY));
    }

    /**
     * del：删除
     */
    @Test
    public void testDel() {
        // 清空数据
        System.out.println("清空数据：" + jedis.flushDB());

        // set数据
        System.out.println("set键值对：" + jedis.set(KEY, VALUE));

        // 删除
        System.out.println("data exists:" + jedis.del(KEY));
    }

    /**
     * Redis-String（字符串操作）
     */
    @Test
    public void testString() {
        /*
         set：单个值set
         get：单个key获取值
         append：key对应value追加值
         mset：批量set
         mget：批量get
         del：根据key清除数据
         */
        jedis.flushDB();

        System.out.println(jedis.set("key3", "value3"));
        System.out.println("在key3后面加入值：" + jedis.append("key3", "End"));
        System.out.println("key3的值：" + jedis.get("key3"));
        System.out.println("增加多个键值对：" + jedis.mset("key01", "value01", "key02", "value02", "key03", "value03"));
        System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03"));
        System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03", "key04"));
        System.out.println("删除多个键值对：" + jedis.del(new String[]{"key01", "key02"}));
        System.out.println("获取多个键值对：" + jedis.mget("key01", "key02", "key03"));

        /*
        setnx：如果key不存在，则能存入值，如果key已经存在，则存入失败
         */
        jedis.flushDB();
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        /*
        getSet：获取key数据，并把最新的值替换掉key对应的value
         */
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        jedis.flushDB();
    }

    /**
     * Redis-List数据结构
     */
    @Test
    public void testList() {
        jedis.flushDB();

        System.out.println("===========添加一个list===========");
        jedis.lpush("collections", "lanhuigu", "zhangsan", "wangwu", "xiaoming", "lsi");

        System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
        System.out.println("collections的长度：" + jedis.llen("collections"));

        jedis.lpush("sortedList排序后", "3", "6", "2", "0", "7", "4");
        System.out.println(jedis.sort("sortedList排序后"));
        System.out.println("sortedList排序后：" + jedis.lrange("sortedList排序后", 0, -1));
    }

    /**
     * 键值对方式
     */
    @Test
    public void testMset() {
        jedis.flushDB();

        jedis.mset(new String[]{"name", "tom", "age", "18", "phone", "12345678999"});
        System.out.printf("姓名：%s，年龄：%s，联系方式：%s", jedis.get("name"), jedis.get("age"), jedis.get("phone"));
    }

    /**
     * 作用:
     * 1、原子操，分布式的原子 JUC Atomic* JVM
     * 2、与expire增加超时处理接口幂等性
     */
    @Test
    public void testIncr() {
        jedis.incr("age");
        System.out.println(jedis.get("age"));
    }

    /**
     * Redis-Hash（散列操作）
     */
    @Test
    public void testHash() {
        jedis.flushDB();

        Map<String, String> map = new HashMap<>();
        map.put("zhangsan", "a");
        map.put("lisi", "b");
        map.put("wangwu", "c");

        jedis.hmset("hash", map);
        jedis.hset("hash", "lanhuigu", "e");

        System.out.println("散列hash的所有键值对为：" + jedis.hgetAll("hash")); //return Map<String,String>
        System.out.println("散列hash的所有键为：" + jedis.hkeys("hash")); //return Set<String>
        System.out.println("散列hash的所有值为：" + jedis.hvals("hash")); //return List<String>
    }

    /**
     * Redis-Set（无序集合操作）
     */
    @Test
    public void testSet() {
        jedis.flushDB();

        System.out.println("============向集合中添加元素============");
        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println(jedis.sadd("eleSet", "e6"));//重复问题 1 or 0
        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));

        System.out.println("=================================");
        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println("============集合运算=================");
        System.out.println("eleSet和eleSet1的交集:" + jedis.sinter("eleSet", "eleSet1"));
        System.out.println("eleSet和eleSet1的并集:" + jedis.sunion("eleSet", "eleSet1"));
        System.out.println("eleSet和eleSet1的差集:" + jedis.sdiff("eleSet", "eleSet1"));//eleSet1中有，eleSet2中没有
    }

    /**
     * Redis-Zset（有序集合操作）
     */
    @Test
    public void testSortedSet() {
        jedis.flushDB();

        Map<String, Double> map = new HashMap<>();
        map.put("zhangsan", 1.2);
        map.put("lisi", 5.0);
        map.put("wangwu", 4.0);

        System.out.println(jedis.zadd("zset", 3, "wangwu"));
        System.out.println(jedis.zadd("zset", map));
        System.out.println("zset中的所有元素：" + jedis.zrange("zset", 0, -1));
        System.out.println("zset中lisi的分值：" + jedis.zscore("zset", "lisi"));
        System.out.println("zset中lisi的排名：" + jedis.zrank("zset", "lisi"));
    }
}
