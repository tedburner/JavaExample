package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/20 17:42
 * @description: 爬楼梯， 使用动态规划求解
 */
public class Code70 {

    public static void main(String[] args) {
        Code70 code = new Code70();
        long start = System.currentTimeMillis();
        System.out.println(code.climbStairs(5));
        System.out.println(code.climb(5));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
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

    /**
     * 递归暴力破解
     * 时间超时
     */
    public int climb(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                dp[i] = i + 1;
            }
            if (i > 1) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}
