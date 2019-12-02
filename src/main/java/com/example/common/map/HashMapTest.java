package com.example.common.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/18 23:22
 * @description: 出现死锁
 */
public class HashMapTest {

    public static void main(String[] args) {

        final HashMap<String, String> map = new HashMap<>(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "jlj" + i).start();
                }
            }
        }, "jlj");
    }
}
