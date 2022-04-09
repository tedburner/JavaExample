package com.example.guava.collection;

import com.google.common.collect.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2022/2/27 11:29
 * @description: Google Guava Collection
 */
public class CollectionCase {

    public static void main(String[] args) {
        // 普通 Collection 创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();

        // 不可变 Collection创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("a", "b", "c");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

        // BiMap: 双向Map（Bidirectional Map）键和值不能重复
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("张三",54);
        biMap.put("李四",23);
        biMap.put("程思",33);
        biMap.put("吴楠",16);

        //key相同value不同，后面的会覆盖前面的
        biMap.put("吴楠",46);
        //启动程序会报错 java.lang.IllegalArgumentException: value already present: 23
        //biMap.put("张刚",23);
        //强行添加，会覆盖
        //biMap.forcePut("张刚",23);
        System.out.println(biMap);
    }
}
