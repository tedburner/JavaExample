package com.example.common.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description:
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            while(true) {
                //处理
            }
            // 处理逻辑
        } finally {
            lock.unlock();
        }
    }
}
