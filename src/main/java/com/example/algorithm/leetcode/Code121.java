package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/18 11:12
 * @description: 买卖股票的最佳时机
 * 题目：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 进阶：
 * 买卖股票的最佳时机 {@link Code121}
 * 买卖股票的最佳时机 II {@link Code122}
 * 买卖股票的最佳时机 III {@link Code123}
 * 买卖股票的最佳时机 IV {@link Code188}
 * 最佳买卖股票时机含冷冻期 {@link Code309}
 * 买卖股票的最佳时机含手续费 {@link Code714}
 * <p>
 * 暴力破解：两层递归遍历
 */
public class Code121 {

    /**
     * 暴力破解
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;//最大利润
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
