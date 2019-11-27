package com.example.common.map;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author: lingjun.jlj
 * @date: 2019/11/27 11:15
 * @description: ConcurrentSkipListMap key and value con not null
 * 内部使用SkipList，跳表插入、删除、查询操作平均时间复杂度O(log n)
 */
public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentSkipListMap();
        map.put("1","a");


        for (Map.Entry<String, String> entry : map.entrySet()) {
            String str = entry.getKey() + " " + entry.getValue();
            System.out.println(str);
        }

    }
}
