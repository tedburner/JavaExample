package com.example.zktest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/22 21:38
 * @description: zookeeper 权限控制
 */
public class ZkAuthSample {

    final static String PATH = "/zk-book-auth-test";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",
                5000, null);
        zooKeeper.addAuthInfo("digest", "foo:true".getBytes());
        zooKeeper.create(PATH, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);


        ZooKeeper zooKeeper1 = new ZooKeeper("127.0.0.1:2181",
                5000, null);
        zooKeeper1.getData(PATH, false, null);
    }
}
