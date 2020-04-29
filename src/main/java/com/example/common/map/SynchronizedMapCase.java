package com.example.common.map;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/28 15:19
 * @description: synchronizedSortedMap 的方法，对每个方法加互斥锁实现线程安全
 */
public class SynchronizedMapCase {

    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap<>();
        SortedMap<String, String> sortedMap = Collections.synchronizedSortedMap(map);
        sortedMap.put("1", "a");
        sortedMap.put("2", "b");
        sortedMap.put("3", "c");
        sortedMap.put("4", "d");
        sortedMap.put("5", "e");
        sortedMap.put("6", "f");

        System.out.println("Synchronized sorted map is: " + sortedMap);
    }
}
