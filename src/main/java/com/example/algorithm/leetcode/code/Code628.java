package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/20 16:30
 * @description: 三个数的最大乘积
 * 需要考虑如果2个负数相乘，然后再乘以正数，最后的结果可能会很大
 * 思路：所以针对上面的情况，只要考虑最大的三个数之和与最小两个数*最大的数，谁的乘积最大即可
 */
public class Code628 {

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100, -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums));
    }
}
