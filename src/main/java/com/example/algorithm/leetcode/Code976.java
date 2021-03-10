package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/30 21:59
 * @description: 三角形的最大周长
 * 三角形条件：两边之和大于第三边
 * 根据条件，判断最长的边是否小于剩下的最长的两条边之和
 */
public class Code976 {

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if (a < (b + c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 6, 2, 3};
        System.out.println(largestPerimeter(A));
    }
}
