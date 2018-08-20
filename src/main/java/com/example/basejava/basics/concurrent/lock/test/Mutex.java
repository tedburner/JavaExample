package com.example.basejava.basics.concurrent.lock.test;

import sun.awt.geom.AreaOp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/18 13:09
 * @description:
 */
public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedLongSynchronizer {
        //释放处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //当前状态为0获取锁
        public boolean tryAcquire(int qcquire) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //释放锁
        public boolean tryRelease(int release) {
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

//        Condition condition() {
//            return new Condition();
//        }
    }

    private final Sync sync = new Sync();

//    public Condition newCondition(){
//        return sync.condition();
//    }

    @Override
    public void lock() {
        sync.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1L);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
