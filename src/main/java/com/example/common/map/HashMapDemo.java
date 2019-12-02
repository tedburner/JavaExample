package com.example.common.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: Lucifer
 * @date: 2018/11/16 14:00
 * @description:
 */
public class HashMapDemo {

    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < 10; i++) {
//            map.put(String.valueOf(i), i);
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//        }

        Map<String, Integer> map = new HashMap<>();
        map.put("2010-01-02", 1);
        map.put("2011-02-02", 2);
        map.put("2012-03-02", 3);
        map.put("2013-04-02", 4);
        map.put("2014-05-02", 5);
        map.put("2015-06-02", 6);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("===============");
        Map<String, Integer> tree = new TreeMap<>();
        tree.put("2010-01-02", 1);
        tree.put("2011-02-02", 2);
        tree.put("2012-03-02", 3);
        tree.put("2013-04-02", 4);
        tree.put("2014-05-02", 5);
        tree.put("2015-06-02", 6);

        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
