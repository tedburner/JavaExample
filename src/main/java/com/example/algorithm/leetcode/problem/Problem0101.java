package com.example.algorithm.leetcode.problem;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/15 16:26
 * @description: 判定字符是否唯一
 */
public class Problem0101 {

    public static boolean isUnique(String astr) {
        int[] hash = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            hash[ch - 'a']++;
        }
        for (int j : hash) {
            if (j >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isUnique(s));
    }
}
