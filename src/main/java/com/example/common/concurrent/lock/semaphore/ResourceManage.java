package com.example.common.concurrent.lock.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 11:01
 * @description:
 */
public class ResourceManage {

    private final Semaphore semaphore;
    private boolean resourceArray[];
    private final ReentrantLock lock;

    public ResourceManage() {
        this.resourceArray = new boolean[10];// 资源状态
        this.semaphore = new Semaphore(10, true);// 控制10个共享资源的使用，使用先进先出的公平模式进行共享;公平模式的信号量，先来的先获得信号量
        this.lock = new ReentrantLock(true);// 公平模式的锁，先来的先选
        //初始化资源
        for (int i = 0; i < 10; i++) {
            resourceArray[i] = true;
        }
    }

    public void useResource(int userId) {
        try {
            semaphore.acquire();

            int id = getResourceId();
            System.out.println("用户" + userId + "正在使用资源，资源" + id + "正在被使用......");
            Thread.sleep(100);
            resourceArray[id] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放信号量，计数器 +1
            semaphore.release();
        }
    }

    private int getResourceId() {
        int id = -1;
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                if (resourceArray[i]) {
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return id;
    }
}
