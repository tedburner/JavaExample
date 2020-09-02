package com.example.zktest.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/2 14:38
 * @description:
 */
public class ZkTest1 {

    private static final String PATH = "/user";
    private static final String PATH_SEQ = "/user/child-";

    public static void main(String[] args) throws Exception {
        String zkAddress = "192.168.60.102:2181";
        // 重试策略，如果连接不上ZooKeeper集群，会重试三次，重试间隔会递增
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, retryPolicy);
        client.start();
        // 下面是创建一个名为"user"的持久节点，其中会存储一个test字符串
        String path = client.create().withMode(CreateMode.PERSISTENT)
                .forPath(PATH, "test".getBytes());
        System.out.println(path);
        // checkExists()方法可以检查一个节点是否存在
        Stat stat = client.checkExists().forPath(PATH);
        System.out.println(stat != null);

        byte[] data = client.getData().forPath(PATH);
        System.out.println("节点下数据内容：" + new String(data));

        stat = client.setData().forPath(PATH, "data".getBytes());
        data = client.getData().forPath(PATH);
        System.out.println("重置后节点下数据内容：" + new String(data));
        for (int i = 0; i < 3; i++) {
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    .forPath(PATH_SEQ + i);
        }
        //获取节点下所有子节点
        List<String> children = client.getChildren().forPath(PATH);
        System.out.println("所有子节点：" + children);

        //删除节点
        client.delete().deletingChildrenIfNeeded().forPath(PATH);
    }
}
