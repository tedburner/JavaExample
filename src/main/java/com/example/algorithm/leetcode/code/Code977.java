package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/16 09:45
 * @description: 有序数组的平方
 */
public class Code977 {

    public int[] sortedSquares(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
