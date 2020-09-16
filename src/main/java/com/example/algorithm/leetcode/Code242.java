package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/15 21:16
 * @description: 有效的字母异位词
 * 判断两个字符串的字符是否相同，如果两个字符串长度不一样，则不相同；然后排序判断
 */
public class Code242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t ="nagaram";
        System.out.println(new Code242().isAnagram(s, t));
    }
}
