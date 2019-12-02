package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/5 13:59
 * @description: Pow(x, n), 即计算 x 的 n 次幂函数。
 */
public class Code50 {

    public static void main(String[] args) {

        System.out.println(myPow(2.00000, 2));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(2.00000, 0));
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        return fastPow(x, n);
    }

    /**
     * 如果不是偶数，需要补上一个x
     */
    public static double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


}
