package com.example.algorithm.LeetCode;

/**
 * @author: Arthas
 * @date: 2019-08-08 22:12
 * @description: 最大子序和  动态规划
 */
public class Code53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int mid = nums[i];
            for (int k = i + 1; k < nums.length; k++) {
                if (max < (mid + nums[k])) {
                    max = mid + nums[k];
                    mid = mid + nums[k];
                    //System.out.println("1：" + mid + "+" + nums[k] + "=" + max);
                } else {
                    mid = mid + nums[k];
                    //System.out.println("2：" + mid + "+" + nums[k] + "=" + mid);
                }
            }
//            System.out.println(max);
        }
        return max;
    }
}
