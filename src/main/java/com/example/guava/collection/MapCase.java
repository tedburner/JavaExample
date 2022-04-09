package com.example.guava.collection;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 12:18
 * @description:
 */
public class MapCase {

    public static void main(String[] args) {
        /**Map的常见用法*/
        Map<String, Object> leftMap = ImmutableMap.of("name", "汪", "age", 18, "address", "陕西", "city", "西安", "love", "张");
        Map<String, Object> rightMap = ImmutableMap.of("name", "张", "age", 16, "address", "陕西", "city", "西安", "home", "美国");
        MapDifference<String, Object> deffMap = Maps.difference(leftMap, rightMap);
        //相同的
        Map<String, Object> map = deffMap.entriesInCommon();
        System.out.println("相同的:" + map);
        //同key不同value
        Map<String, MapDifference.ValueDifference<Object>> stringValueDifferenceMap = deffMap.entriesDiffering();
        System.out.println("同key不同value:" + stringValueDifferenceMap);
        //仅仅左边有的
        Map<String, Object> onlyLeft = deffMap.entriesOnlyOnLeft();
        System.out.println("仅仅左边有的:" + onlyLeft);
        //仅仅右边有的
        Map<String, Object> onlyRight = deffMap.entriesOnlyOnRight();
        System.out.println("仅仅右边有的:" + onlyRight);
    }
}
