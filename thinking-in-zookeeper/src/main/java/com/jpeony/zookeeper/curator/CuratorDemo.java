package com.jpeony.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * @author yihonglei
 */
public class CuratorDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                builder().connectString("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183").
                sessionTimeoutMs(4000).retryPolicy(new
                ExponentialBackoffRetry(1000, 3)).
                namespace("").build();
        curatorFramework.start();
        Stat stat = new Stat();
        // 查询节点数据
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/hello");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }
}
