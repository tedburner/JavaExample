package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Arthas
 * @date: 2019-07-26 23:04
 * @description: 罗马数字转整数
 */
public class Code13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        //如果传入的罗马数字就是Map中的，就直接返回
        if (map.containsKey(s)) {
            return map.get(s);
        }
        //优先去2个字符，如果存在特殊字符中，就去其值，否则取一个字符
        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length()) {
                String two_char = s.substring(i, i + 2);
                if (map.containsKey(two_char)) {
                    //System.out.println("截取2位：" + two_char + " " + map.get(two_char));
                    sum = sum + map.get(two_char);
                    i = i + 2;
                } else {
                    String one_char = s.substring(i, i + 1);
                    //System.out.println("第一处截取1位" + one_char + " " + map.get(one_char));
                    sum = sum + map.get(one_char);
                    i++;
                }
            } else {
                String one_char = s.substring(i, i + 1);
                //System.out.println("第二处截取1位" + one_char + " " + map.get(one_char));
                sum = sum + map.get(one_char);
                i++;
            }

        }
        return sum;
    }
}
