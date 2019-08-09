package com.example.algorithm.LeetCode;

/**
 * @author: Arthas
 * @date: 2019-08-08 22:12
 * @description: 最大子序和  动态规划
 */
public class Code53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int reslut = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            reslut = Math.max(sum, reslut);
        }
        return reslut;
    }
}
