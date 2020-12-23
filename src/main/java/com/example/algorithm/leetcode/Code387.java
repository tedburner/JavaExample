package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/23 15:08
 * @description: 字符串中的第一个唯一字符
 */
public class Code387 {

    public static int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            int num = hashMap.get(s.charAt(i));
            if (num == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
