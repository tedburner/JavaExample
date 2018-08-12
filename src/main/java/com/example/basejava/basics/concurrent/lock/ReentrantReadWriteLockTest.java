package com.example.basejava.basics.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/7 17:01
 * @description:
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //读锁
        lock.readLock().lock();
        lock.readLock().unlock();
        //写锁
        lock.writeLock().lock();
        lock.writeLock().unlock();
    }
}
