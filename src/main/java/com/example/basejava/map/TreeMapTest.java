package com.example.basejava.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/16 21:56
 * @description: treeMap
 */
public class TreeMapTest {

    static Comparator comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.parseInt(o2.toString()) - Integer.parseInt(o1.toString());
        }
        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "b");
        map.put(4, "d");
        map.put(3, "c");
        map.put(1, "a");
        //如果不存在，则插入，否则返回原有
        String value = map.putIfAbsent(1, "a");
        System.out.println(value);
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> each : entrySet) {
            System.out.println(each.getKey() + "::" + each.getValue());
        }
        //返回第一个key小于参数的Entry
        System.out.println(((TreeMap<Integer, String>) map).lowerEntry(2));
        //返回第一个key小于参数的key
        System.out.println(((TreeMap<Integer, String>) map).lowerKey(2));

        //comparator是倒序排序
        Map<Integer, Integer> treeMap = new TreeMap<>(comparator);

        for (int i = 0; i < 10; i++) {
            treeMap.put(i, i);
        }
        Set<Map.Entry<Integer, Integer>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, Integer> each : entries) {
            System.out.println(each.getKey() + "::" + each.getValue());
        }
    }

}
