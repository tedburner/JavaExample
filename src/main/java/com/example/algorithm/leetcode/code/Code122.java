package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/18 11:11
 * @description: 买卖股票的最佳时机 II
 * 题目：给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 进阶：
 * 买卖股票的最佳时机 {@link Code121}
 * 买卖股票的最佳时机 II {@link Code122}
 * 买卖股票的最佳时机 III {@link Code123}
 * 买卖股票的最佳时机 IV {@link Code188}
 * 最佳买卖股票时机含冷冻期 {@link Code309}
 * 买卖股票的最佳时机含手续费 {@link Code714}
 * <p>
 * 思路：动态规划，设置一个二维矩阵标识状态
 * 定义状态:
 * dp[i][0] 表示第i天交易完后手里没有股票的最大利润，
 * dp[i][1] 表示第i天交易完后手里持有一支股票的最大利润（i从0开始）
 */
public class Code122 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 前一天收益或者前一天结束时候手上持有一直股票，即 dp[i-1][1]，这是我们卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 前一天已经持有一只股票dp[i - 1][1]，或 前一天结束还没股票，这是我们买入 dp[i - 1][1] - prices[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
