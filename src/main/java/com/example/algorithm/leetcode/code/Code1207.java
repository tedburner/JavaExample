package com.example.algorithm.leetcode.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/28 10:53
 * @description: 独一无二的出现次数
 */
public class Code1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int num : arr) {
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }
        Set<Integer> hash = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            hash.add(entry.getValue());
        }
        return cache.size() == hash.size();
    }
}
