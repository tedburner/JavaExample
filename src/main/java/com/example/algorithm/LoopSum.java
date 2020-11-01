package com.example.algorithm;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-29 18:03
 * @description: ⼀个从0-9的封闭环，即是0-1-2-3-4-5-6-7-8-9-0, 可以正向⾛，
 * 也可以逆向⾛; 请问⾛n步回到0有⼏种不同的⾛法（譬如n 为2, 0-1-0, 0-9-0共有两种⾛法）
 */
public class LoopSum {

    final static int N = 10;

    static long a[][] = new long[N][N];

    static {
        for (int i = 0; i < N; i++) {
            a[i][(i + 1) % N] = a[(i + 1) % N][i] = 1;
        }
    }

    public static long[][] mut(int k, int n, long[][] A) {
        long[][] res = new long[n][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (i == j) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        while (k != 0) {
            if ((k & 1) == 1) res = f(res, A);
            k >>= 1;
            A = f(A, A);
        }
        return res;
    }

    public static long[][] f(long[][] A, long[][] B) {
        long res[][] = new long[A.length][B.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(mut(2, 10, a)[0][0]);
        System.out.println(mut(3, 10, a)[0][0]);
        System.out.println(mut(4, 10, a)[0][0]);
        System.out.println(mut(5, 10, a)[0][0]);
        System.out.println(mut(6, 10, a)[0][0]);
        System.out.println(mut(7, 10, a)[0][0]);
        System.out.println(mut(8, 10, a)[0][0]);
    }


}


