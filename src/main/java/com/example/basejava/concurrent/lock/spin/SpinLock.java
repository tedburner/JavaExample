package com.example.basejava.concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 11:16
 * @description: 自旋锁
 */
public class SpinLock {

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    /**
     * <pre>
     * getAndSet原子操作来判断锁状态并尝试获取锁
     * 缺点：getAndSet底层使用CAS来实现，一直在修改共享变量的值，会引发缓存一致性流量风暴
     * </pre>
     */
    public void lock() {
        while (atomicBoolean.getAndSet(true)) {

        }
    }

    /**
     * 释放锁
     */
    public void unlock() {
        atomicBoolean.set(false);
    }

}
