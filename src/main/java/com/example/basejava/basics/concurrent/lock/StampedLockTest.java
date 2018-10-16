package com.example.basejava.basics.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.StampedLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/16 09:23
 * @description: StampedLock 锁测试单元
 */
public class StampedLockTest {

    private static double x, y;
    private static final StampedLock lock = new StampedLock();

    public static void move(double deltaX, double deltaY) {
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static double distanceFromOrigin() {
        long stamp = lock.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public static void moveIfAtOrigin(double newX, double newY) {
        long stamp = lock.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = lock.tryConvertToWriteLock(stamp);
                if (!Objects.equals(ws, 0L)) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    lock.unlockRead(stamp);
                    stamp = lock.writeLock();
                }
            }
        } finally {
            lock.unlock(stamp);
        }

    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(100);
        for (int j = 0; j < 20; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        move(x, y);
                        distanceFromOrigin();
                        moveIfAtOrigin(x, y);
                    }
                }
            });
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
