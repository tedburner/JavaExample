package com.example.algorithm.LeetCode;

/**
 * @author: Arthas
 * @date: 2019/8/28 23:13
 * @description: 实现 strStr()
 */
public class Code28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ew"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int len = haystack.length();
        int n = needle.length();
        if (len < n) {
            return -1;
        }
        for (int i = 0; i <=(len - n); i++) {
            String str = haystack.substring(i, i + n);
            System.out.println(str);
            if (str.equals(needle)) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
