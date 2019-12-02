package com.example.common.concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 11:16
 * @description: 自旋锁 非公平锁，CAS，非可重入锁
 * @benfit:相应速度更快，因为不切换线程状态
 * @bad: 线程数量达到一定量时，性能下降
 */
public class SpinLock {

    private AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    /**
     * <pre>
     * getAndSet原子操作来判断锁状态并尝试获取锁
     * 缺点：getAndSet底层使用CAS来实现，一直在修改共享变量的值，会引发缓存一致性流量风暴
     * </pre>
     */
    public void lock() {
        Thread thread = Thread.currentThread();
        while (atomicReference.compareAndSet(null, thread)) {
        }
    }

    /**
     * 释放锁
     */
    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
    }

}
