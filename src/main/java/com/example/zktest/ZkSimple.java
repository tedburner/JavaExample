package com.example.zktest;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/22 20:57
 * @description:
 */
public class ZkSimple implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event : " + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",
                5000,
                new ZkSimple());
        System.out.println("zk state : " + zooKeeper.getState());
        try {
            countDownLatch.await();
        } catch (Exception e) {
        }
        System.out.println("Zookeeper session established.");
    }
}
