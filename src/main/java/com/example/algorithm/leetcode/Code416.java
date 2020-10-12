package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/11 22:12
 * @description: 分割等和子集
 * 思路：动态规划，背包问题。数组总合一半，设为背包容量，如果数组能够填充背包容量，那么数组就是可以分割等和子集
 */
public class Code416 {

    public static boolean canPartition(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        //计算数组合
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        //如果数组合不是偶数，就不符合要求
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        //创建二维状态数组，行：物品索引，列：容量
        boolean[][] dp = new boolean[length][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean flag = canPartition(nums);
        System.out.println("数组能否分割：" + flag);
    }
}
