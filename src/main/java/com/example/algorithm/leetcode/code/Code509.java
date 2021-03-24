package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 16:12
 * @description: 斐波那契数 f(0) = 0; f(1) =1; 当N>2, f(n) = f(n-1) + f(n-2)
 * 使用递归算法
 */
public class Code509 {

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(4));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
