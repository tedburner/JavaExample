package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/9 14:39
 * @description: 搜索插入位置
 */
public class Code35 {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] < target && nums[i] >= target) {
                return i;
            }
        }
        return length;
    }

}
