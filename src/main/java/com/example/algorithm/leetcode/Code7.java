package com.example.algorithm.leetcode;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description: 反整数：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Code7 {

    public static void main(String[] args) {
        System.out.println(reverse(-123));

    }


    public static int reverse(int x) {

        int y = 0;
        int n;
        while (x != 0) {
            n = x % 10;
            // [−2^31,  2^31 − 1]，请根据这个假设，如果反转后整数溢出那么就返回 0
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + n;
            x /= 10;
        }
        return y;
    }
}
