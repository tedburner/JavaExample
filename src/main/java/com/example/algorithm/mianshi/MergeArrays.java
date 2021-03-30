package com.example.algorithm.mianshi;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/30 16:52
 * @description: 滴滴面试——合并多个有序数组
 */
public class MergeArrays {

    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] ans = new int[len1 + len2];
        int j = 0;
        int k = 0;
        int i = 0;
        while (j < len1 && k < len2) {
            if (arr1[j] <= arr2[k]) {
                ans[i++] = arr1[j];
                j++;
            } else {
                ans[i++] = arr2[k];
                k++;
            }
        }
        // 把还没进行合并的元素直接添加到新数组后面
        while (j < len1) {
            ans[i++] = arr1[j++];
        }
        while (k < len2) {
            ans[i++] = arr2[k++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6};
        int[] arr2 = {1, 2, 5, 7};
        int[] arr3 = {3, 6, 9, 11};
        int[] arr4 = {5, 7, 13, 17};

        int[] merge1 = merge(arr1, arr2);
        int[] merge2 = merge(arr3, arr4);
        int[] merge = merge(merge1, merge2);
        System.out.println(Arrays.toString(merge));
    }
}
