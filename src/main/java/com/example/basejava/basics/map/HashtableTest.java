package com.example.basejava.basics.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/16 22:15
 * @description:
 */
public class HashtableTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "a");
        map.get(1);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }
}
