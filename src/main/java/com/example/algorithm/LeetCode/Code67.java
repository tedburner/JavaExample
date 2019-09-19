package com.example.algorithm.LeetCode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/19 14:35
 * @description: 二进制求和
 */
public class Code67 {

    public static void main(String[] args) {

    }

    public static String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        int aLen1 = len1, aLen2 = len2;
        for (int i = len - 1; i >= 0; i--) {
            if (len > len1) {

            } else if (len > len2) {

            } else {
                String c = a.substring(len1-1,len1);
            }
        }
    }
}
