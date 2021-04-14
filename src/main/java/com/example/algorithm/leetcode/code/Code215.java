package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/14 23:03
 * @description: 数组中的第K个最大元素
 */
public class Code215 {

    public static int findKthLargest(int[] nums, int k) {
        //排序，冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // 遍历查找第K个数字
        return nums[k - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
