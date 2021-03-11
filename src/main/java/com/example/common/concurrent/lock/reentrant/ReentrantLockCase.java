package com.example.common.concurrent.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2020/7/27 14:47
 * @description: 公平锁和非公平锁
 */
public class ReentrantLockCase {

    private static final ReentrantLock fairLock = new ReentrantLock(true);
    private static final ReentrantLock unFairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        //公平锁加锁
        fairLock.lock();
        //do something
        fairLock.unlock();

        //非公平锁
        unFairLock.lock();
        //do something
        unFairLock.unlock();
    }

}
