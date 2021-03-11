package com.example.algorithm;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/11 22:29
 * @description: 0-1背包
 */
public class ZeroAndOne {


    public static int zeroOneKnapsack(int N, int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];//每个物品的体积和价值
            for (int j = W; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{4, 1, 2, 3};
        int[] values = new int[]{5, 2, 4, 4};
        int total = zeroOneKnapsack(4, 4, weights, values);
        System.out.println(total);
    }
}
