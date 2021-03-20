package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/26 21:11
 * @description: 有多少小于当前数字的数字
 */
public class Code1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        int[] ans = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ans));
    }
}
