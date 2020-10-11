package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/11 22:12
 * @description: 分割等和子集
 * 思路：动态规划
 */
public class Code416 {

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean flag = canPartition(nums);
        System.out.println("数组能否分割：" + flag);
    }
}
