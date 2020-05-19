package com.example.common.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2019-02-16 16:14
 * @description: 引用队列
 */
public class ReferenceQueueDemo {

    private static ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
    private static int _1M = 1024 * 1024;

    public static void main(String[] args) {

        Object object = new Object();
        Map<Object, Object> map = new HashMap<>();

        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while ((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch (InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[_1M];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes, referenceQueue);
            map.put(weakReference, object);
        }
        System.out.println("map.size->" + map.size());

    }
}
