package com.example.basejava.concurrent.queue;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 17:10
 * @description:
 */
public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }


    }
}
