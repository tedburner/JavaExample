package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/3 11:17
 * @description: 有效的山脉数组
 * 条件：A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class Code941 {

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int length = A.length;
        if (A[0] >= A[1]) {
            return false;
        }
        int p = 1;
        while (p + 1 < length && A[p] < A[p + 1]) {
            p++;
        }
        if (p == 0 || p == length - 1) {
            return false;
        }
        while (p + 1 < length && A[p] > A[p + 1]) {
            p++;
        }
        return p == (length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 5, 2, 1, 0};
        System.out.println(validMountainArray(nums));
    }
}
