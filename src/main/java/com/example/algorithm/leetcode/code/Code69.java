package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/19 14:13
 * @description: x 的平方根
 */
public class Code69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(9));
    }

    /**
     * 使用二分法求平方根
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double low = 0;
        double high = x;
        double p = 0.0002;
        double mid = (low + high) / 2.0;
        while (true) {
            double num = mid * mid;
            if (x - num < p && num - x < p) {
                break;
            }
            mid = (low + high) / 2.0;
            if (mid * mid > x) {
                high = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return (int) mid;
            }
        }
        return (int) mid;
    }
}
