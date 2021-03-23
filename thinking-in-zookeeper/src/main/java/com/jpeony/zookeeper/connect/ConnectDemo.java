package com.jpeony.zookeeper.connect;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * 原生连接
 *
 * @author yihonglei
 */
public class ConnectDemo {
    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183",
                    4000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (Event.KeeperState.SyncConnected == event.getState()) {
                        // 如果收到了服务端的响应事件，连接成功
                        countDownLatch.countDown();
                    }
                }
            });

            countDownLatch.await();
            // CONNECTED
            System.out.println(zooKeeper.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
