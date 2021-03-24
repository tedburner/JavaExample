package com.example.algorithm.leetcode.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/2 11:40
 * @description: 两个数组的交集
 */
public class Code349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    hash.add(nums1[i]);
                }
            }
        }
        if (hash.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[hash.size()];
        int index = 0;
        for (Integer num : hash) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
    }
}
