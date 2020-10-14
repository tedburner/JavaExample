package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/14 09:20
 * @description: 查找常用字符
 * <p>
 * 思路：统计每个字符串中字母出现的次数，然后所以字符串相同字母做交集，取最小的次数，即这个字母在所以字符串中出现的次数了
 */
public class Code1002 {

    public static List<String> commonChars(String[] A) {
        int num = 26;
        int[] minTimes = new int[num];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        for (String word : A) {
            int length = word.length();
            //字符串中字母出现的频率
            int[] freq = new int[num];
            for (int i = 0; i < length; i++) {
                Character ch = word.charAt(i);
                //按照字母顺序排队
                freq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                //对每个字母取交集
                minTimes[i] = Math.min(minTimes[i], freq[i]);
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int times = minTimes[i];
            if (times > 0) {
                //每个字母可能出现多次
                for (int j = 0; j < times; j++) {
                    list.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};
        System.out.println(commonChars(words));

    }
}
