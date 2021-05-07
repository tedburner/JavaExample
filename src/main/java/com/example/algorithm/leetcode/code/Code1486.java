package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/5/7 21:36
 * @description: 数组异或操作
 */
public class Code1486 {

    public static int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = start + 2 * i;
            ans = ans ^ num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(1,7));
    }
}
