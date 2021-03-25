package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/24 10:41
 * @description: 位1的个数
 * 思路：循环检查给定整数N的二进制的每一位是否为1.当检查第 i 位时，可以让 n 与 2^i 进行与运算，当且仅当 n 的第 i 位为1时，运算结果不为 0
 */
public class Code191 {

    public static int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = Integer.bitCount(00000000000001001001);
        System.out.println(n);
    }
}
