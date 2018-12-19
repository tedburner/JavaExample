package com.example.common.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lingjun.jlj
 * @data 2018/5/1
 * @Description:
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "1");
        map.put(2, "2");
    }
}
