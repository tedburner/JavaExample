package com.example.basejava.basics.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/16 21:56
 * @description: treeMap
 */
public class TreeMapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "a");
        //如果不存在，则插入，否则返回原有
        String value = map.putIfAbsent(1, "a");
    }
}
