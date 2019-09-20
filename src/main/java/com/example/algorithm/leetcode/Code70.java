package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/20 17:42
 * @description: 爬楼梯， 使用动态规划求解
 */
public class Code70 {

    public static void main(String[] args) {
        Code70 code = new Code70();
        System.out.println(code.climbStairs(0));
    }

    public int climbStairs(int n) {
        return climb(0, n);
    }

    /**
     * 递归暴力破解
     * 时间超时
     */
    public int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }
}
