package com.example.basejava.keyword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 **/
public class StaticTest {

    private static final Map<Integer, String> recordTypeMap = new HashMap<>();

    static {
        recordTypeMap.put(1, "A");
        recordTypeMap.put(2, "B");
        recordTypeMap.put(3, "C");
        recordTypeMap.put(4, "D");
        recordTypeMap.put(5, "E");
    }

    public static void main(String[] args) {
        System.out.println(recordTypeMap.get(1));
    }
}
