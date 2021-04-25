package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 16:36
 * @description: 合并两个有序数组
 */
public class Code88 {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            nums1 = nums2;
            return;
        }
        if (n == 0) {
            return;
        }
        int k = m + n;
        int i = 0, j = 0;
        while (i < m && j < n) {

        }

    }

    /**
     * 双指针，新增一个临时数组，作为合并后的数组
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];
        int p1 = 0, p2 = 0;
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            temp[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }
    }

    /**
     * 直接合并后，在排序
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge2(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}
