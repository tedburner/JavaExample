package com.example.test.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/15 09:14
 * @description: ConcurrentHashMap.computeIfAbsent 死循环样例
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        System.out.println("方法开始...");
        Map<String, String> hashMap = new ConcurrentHashMap<>(16);
        String str = hashMap.get("demo");
        System.out.println("第一次获取的值：" + str);
        hashMap.computeIfAbsent("demo", key -> getValue());
        str = hashMap.get("demo");
        System.out.println("第二次获取值：" + str);


        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        //死循环样例
        map.computeIfAbsent("AaAa",
                key -> {
                    return map.computeIfAbsent("BBBB", key2 -> 42);
                });
        System.out.println("方法结束 map: " + map);
    }

    private static String getValue() {
        return "蒋先森";
    }
}
