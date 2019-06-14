package com.example.algorithm;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/13 16:13
 * @description:
 */
public class Sqrt {


    /**
     * 二分法开根号
     *
     * @param x 需要开根号的数字
     */
    public static double sqrt(double x) {
        System.out.println(x + " 开根号后的值： " + Math.sqrt(x));
        double low = 0;
        double high = x;
        double p = 0.002;//设置精度
        double mid = (low + high) / 2.0;
        while (true) {
            System.out.println("二分法中间计算值： " + mid);
            double num = mid * mid;
            if (x - num < p && num - x < p) {
                break;
            }
            mid = (low + high) / 2;

            if (mid * mid > x) {
                high = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }

    /**
     * 使用牛顿法开根号
     *
     * @param n 参数
     */
    public static double sqrt_2(double n) {
        System.out.println(n + " 开根号后的值： " + Math.sqrt(n));
        double x = 1.0;//初始值
        double p = 0.001;
        while (Math.abs(x * x - n) > p) {
            x = (x + n / x) / 2;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(sqrt(3));

        System.out.println("============牛顿法开根号==========");

        System.out.println(sqrt_2(3));
    }
}
