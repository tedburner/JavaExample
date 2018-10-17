package com.example.basejava.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lingjun.jlj
 * @data 2018/5/10
 * @Description:
 */
public class ReadWriteLock {
    private static volatile ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static volatile Lock lock = new ReentrantLock();
    public static void main(String[] args) {

        Object data = null;
        //上读锁，其他线程只能读不能写
        readWriteLock.readLock().lock();
        try {
            //do something
        }finally {
            readWriteLock.readLock().unlock();
        }
        //上写锁，不允许其他线程读也不允许写
        readWriteLock.writeLock().lock();
        try {
            //do something
        }finally {
            readWriteLock.writeLock().unlock();
        }
        lock.lock();
        try {

        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

}
