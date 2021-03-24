package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 16:36
 * @description: 合并两个有序数组
 */
public class Code88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy_array = Arrays.copyOf(nums1, m);
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < m && index2 < n) {
            nums1[index++] = copy_array[index1] < nums2[index2] ? copy_array[index1++] : nums2[index2++];
//            if (copy_array[index1] < nums2[ index2]) {
//                nums1[index] = copy_array[index1];
//                index1++;
//            } else {
//                nums1[index] = nums2[index2];
//                index2++;
//            }
//            index++;
        }
        //跳出循环，表明有一个数组，循环结束了，这时候另外一个数据还没遍历结束，则，直接将剩下的拷贝到过去
        if (index1 < m) System.arraycopy(copy_array, index1, nums1, index1 + index2, m + n - index1 - index2);
        if (index2 < n) System.arraycopy(nums2, index2, nums1, index1 + index2, m + n - index1 - index2);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(num1);
    }
}
