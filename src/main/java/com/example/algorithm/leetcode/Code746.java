package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/21 21:27
 * @description: 使用最小花费爬楼梯
 * 思路：使用动态规划，判断走一步和走两步的大小
 */
public class Code746 {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
