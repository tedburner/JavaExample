package com.example;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/22 16:19
 * @description: 欧几里德算法求最大公约数
 */
public class Gcd {

    public static void main(String[] args) {
        System.out.println(gcd(48, 120));
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println(r);
        return gcd(q, r);
    }
}
