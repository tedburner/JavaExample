package com.example.common.concurrent.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/15 17:44
 * @description: ThreadLocalMap 弱引用 GC 问题
 */
public class ThreadLocalWeakReferenceGCDemo {

    private static final int THREAD_LOOP_SIZE = 20;

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            ThreadLocal<Map<Integer, String>> threadLocal = new ThreadLocal<>();
            Map<Integer, String> map = new HashMap<>();
            map.put(i, "我是第" + i + "个ThreadLocal数据");
            threadLocal.set(map);
            threadLocal.get();

            System.out.println("第"+i+"次获取ThreadLocal中的数据");

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
