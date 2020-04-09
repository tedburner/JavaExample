package com.example.zktest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: Arthas
 * @date: 2019-03-05 10:57
 * @description: zookeeper实现分布式锁
 */
public class ZkDistributedLock implements Lock, Watcher {

    private ZooKeeper zk;
    /**
     * 分布式锁根
     */
    private String root = "/locks";
    /**
     * 竞争资源的标志
     */
    private String lockName;
    /**
     * 等待前一个锁
     */
    private String waitNode;
    /**
     * 当前锁
     */
    private String myZnode;
    /**
     * 计数器
     */
    private CountDownLatch latch;
    private CountDownLatch connectedSignal = new CountDownLatch(1);
    private int sessionTimeout = 30000;

    /**
     * 创建分布式锁,使用前请确认config配置的zookeeper服务可用
     *
     * @param config   127.0.0.1:2181
     * @param lockName 竞争资源标志,lockName中不能包含单词_lock_
     */
    public ZkDistributedLock(String config, String lockName) {
        this.lockName = lockName;
        // 创建一个与服务器的连接
        try {
            zk = new ZooKeeper(config, sessionTimeout, this);
            connectedSignal.await();
            //此处不执行 Watcher
            Stat stat = zk.exists(root, false);
            if (stat == null) {
                // 创建根节点
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建分布式锁,使用前请确认config配置的zookeeper服务可用
     *
     * @param lockName 竞争资源标志，lockName中不能包含单词 _lock_
     */
    public ZkDistributedLock(String lockName) {
        this.lockName = lockName;
        // 创建一个与服务器的连接
        try {
            zk = new ZooKeeper("127.0.0.1:2181", sessionTimeout, this);
            connectedSignal.await();
            //此处不执行 Watcher
            Stat stat = zk.exists(root, false);
            if (stat == null) {
                // 创建根节点
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void lock() {
        try {
            if (this.tryLock()) {
                System.out.println("Thread " + Thread.currentThread().getId() + " " + myZnode + " get lock true");
            } else {
                //等待锁
                waitForLock(waitNode, sessionTimeout);
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }

    @Override
    public boolean tryLock() {
        try {
            String splitStr = "_lock_";
            if (lockName.contains(splitStr)) {
                throw new RuntimeException("lockName can not contains \\u000B");
            }
            //创建临时顺序子节点，避免出现死锁，以及在前一个锁失效时，并发尝试加锁
            myZnode = zk.create(root + "/" + lockName + splitStr, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(myZnode + " is created ");
            //取出所有子节点
            List<String> subNodes = zk.getChildren(root, false);
            //取出所有lockName的锁
            List<String> lockObjNodes = new ArrayList<>();
            for (String node : subNodes) {
                String _node = node.split(splitStr)[0];
                if (_node.equals(lockName)) {
                    lockObjNodes.add(node);
                }
            }
            Collections.sort(lockObjNodes);

            if (myZnode.equals(root + "/" + lockObjNodes.get(0))) {
                //如果是最小的节点,则表示取得锁
                System.out.println(myZnode + "==" + lockObjNodes.get(0));
                return true;
            }
            //如果不是最小的节点，找到比自己小1的节点
            String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);
            //找到前一个子节点
            waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        try {
            if (this.tryLock()) {
                return true;
            }
            return waitForLock(waitNode, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean waitForLock(String lower, long waitTime) throws InterruptedException, KeeperException {
        //同时注册监听
        Stat state = zk.exists(root + "/" + lower, true);
        //判断比自己小一个数的节点是否存在,如果不存在则无需等待锁,同时注册监听
        if (state != null) {
            System.out.println("Thread " + Thread.currentThread().getId() + " waiting for " + root + "/" + lower);
            this.latch = new CountDownLatch(1);
            //等待，这里应该一直等待其他线程释放锁
            this.latch.await(waitTime, TimeUnit.MILLISECONDS);
            this.latch = null;
        }
        return true;
    }

    @Override
    public void unlock() {
        try {
            System.out.println("unlock " + myZnode);
            zk.delete(myZnode, -1);
            myZnode = null;
            zk.close();
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * zookeeper节点的监视器
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        //建立连接用
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
            return;
        }
        //其他线程放弃锁的标志
        if (this.latch != null) {
            this.latch.countDown();

        }
    }
}
