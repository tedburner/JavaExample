package com.example.common.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2021/6/3 15:35
 * @description:
 * LinkedHashMap 是继承与 HashMap，是基于 HashMap 和双向链表实现的。
 * LinkedHashMap 是有序的，可以分为插入顺序和访问顺序两种。
 */
public class LinkedHashMapCase {

    public static void main(String[] args) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
