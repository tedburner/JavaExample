package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/20 22:59
 * @description: 计数质数
 */
public class Code204 {

    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 2; i < n; i++) {
            //判断是否是质数
            boolean isPrimes = isPrimes(i);
            sum += isPrimes ? 1 : 0;
        }
        return sum;
    }

    public boolean isPrimes(int x) {
        for (int i = 2; i * i <=x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new Code204().countPrimes(10));
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
