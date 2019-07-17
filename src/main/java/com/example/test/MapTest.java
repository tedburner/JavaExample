package com.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/12 17:20
 * @version：1.0.0
 * @description:
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("test", 1);
        map.put("test1", "test");
        System.out.println(map.get("test"));
        System.out.println(map.get("test1"));
    }
}
