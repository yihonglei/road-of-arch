package com.jpeony.redis.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Redis集群访问
 *
 * @author yihonglei
 */
public class RedisCluster {
    public static void main(String[] args) throws IOException {

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();

        jedisClusterNode.add(new HostAndPort("10.6.202.104", 6381));

        jedisClusterNode.add(new HostAndPort("10.6.202.105", 6381));

        jedisClusterNode.add(new HostAndPort("10.6.202.106", 6381));

        jedisClusterNode.add(new HostAndPort("10.6.202.104", 6380));

        jedisClusterNode.add(new HostAndPort("10.6.202.105", 6380));

        jedisClusterNode.add(new HostAndPort("10.6.202.106", 6380));

        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(100);

        config.setMaxIdle(10);

        config.setTestOnBorrow(true);

        //connectionTimeout：指的是连接一个url的连接等待时间

        //soTimeout：指的是连接上一个url，获取response的返回等待时间

        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode,
                6000, 5000, 10, "qBa39fA&?@-o", config);

        jedisCluster.set("dispatcher_test:didi_driver_order_10105721", "hello");

        System.out.println(jedisCluster.get("dispatcher_test:didi_driver_order_10105721"));

        jedisCluster.close();
    }
}
