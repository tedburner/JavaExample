package com.example.zktest.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/2 14:38
 * @description:
 */
public class ZkBackgroundTest {

    private static final String PATH = "/user";
    private static final String PATH_SEQ = "/user/child-";

    public static void main(String[] args) throws Exception {
        String zkAddress = "192.168.60.102:2181";
        // 重试策略，如果连接不上ZooKeeper集群，会重试三次，重试间隔会递增
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, retryPolicy);
        client.start();
        // 添加CuratorListener监听器，针对不同的事件进行处理
        client.getCuratorListenable().addListener(new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                switch (event.getType()) {
                    case CREATE:
                        System.out.println("CREATE:" + event.getPath());
                    case DELETE:
                        System.out.println("DELETE:" + event.getPath());
                    case EXISTS:
                        System.out.println("EXISTS:" + event.getPath());
                    case GET_DATA:
                        System.out.println("GET_DATA:" + event.getPath() + "," + new String(event.getData()));
                    case SET_DATA:
                        System.out.println("SET_DATA:" + new String(event.getData()));
                    case CHILDREN:
                        System.out.println("CHILDREN:" + event.getPath());
                    default:
                }
            }
        });

        // 下面所有的操作都添加了inBackground()方法，转换为后台操作
        client.create().withMode(CreateMode.PERSISTENT)
                .inBackground().forPath(PATH, "test".getBytes());
        client.checkExists().inBackground().forPath(PATH);
        client.setData().inBackground().forPath(PATH, "setData-Test".getBytes());
        client.setData().inBackground().forPath(PATH);
        for (int i = 0; i < 3; i++) {
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    .inBackground().forPath(PATH_SEQ);
        }
        client.getChildren().inBackground().forPath(PATH);
        // 添加BackgroundCallback
        client.getChildren().inBackground(new BackgroundCallback() {
            public void processResult(CuratorFramework client,
                                      CuratorEvent event) throws Exception {
                System.out.println("in background:" + event.getType() + "," + event.getPath());
            }
        }).forPath(PATH);
        client.delete().deletingChildrenIfNeeded().inBackground()
                .forPath(PATH);
        System.in.read();
    }
}
