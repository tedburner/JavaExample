package com.example.utils.redis;

import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/26 11:30
 * @description: Redisson 用例
 */
public class RedissonUtils {

    public static RedissonClient redisson() {
        Config config = new Config();
        config.setLockWatchdogTimeout(50L)
                .useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RedissonClient client = redisson();
        RAtomicLong longObject = client.getAtomicLong("myLong");
        //同步执行方法
        Boolean res1 = longObject.compareAndSet(3, 3);
        System.out.println("同步执行方法:" + res1);
        //异步执行方法
        RFuture<Boolean> result = longObject.compareAndSetAsync(3, 401);
        System.out.println("异步执行方法:" + result.get());

        //获取分布式锁
        RLock lock = client.getLock("anyLock");

        //加锁10秒自动解锁，无需调用unlock手动释放锁
        lock.lock(10, TimeUnit.SECONDS);

        System.out.println("RLock 上锁");
        Thread.sleep(10000);

        lock.unlock();
        System.out.println("RLock 释放锁");

        //尝试加锁，最多等待100秒，上锁后10秒自动解锁
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            try {
                //...
            } finally {
                lock.unlock();
            }
        }

        //异步执行
        lock.lockAsync();
        lock.lockAsync(10, TimeUnit.SECONDS);
        RFuture<Boolean> future = lock.tryLockAsync(100, 10, TimeUnit.SECONDS);

        //公平锁
        RLock fairLock = client.getFairLock("fairLock");
        fairLock.lock();

        //联锁
        RLock lock1 = client.getLock("lock1");
        RLock lock2 = client.getLock("lock2");
        RLock lock3 = client.getLock("lock3");

        RedissonMultiLock multiLock = new RedissonMultiLock(lock1, lock2, lock3);
        // 同时加锁：lock1 lock2 lock3
        // 所有的锁都上锁成功才算成功。
        multiLock.lock();
        //...
        multiLock.unlock();

        //红锁
        //基于Redis的Redisson红锁RedissonRedLock对象实现了Redlock介绍的加锁算法。
        // 该对象也可以用来将多个RLock对象关联为一个红锁，每个RLock对象实例可以来自于不同的Redisson实例。

        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        // 同时加锁：lock1 lock2 lock3
        // 红锁在大部分节点上加锁成功就算成功。
        redLock.lock();
        //...
        redLock.unlock();

    }

}
