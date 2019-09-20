package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/9 14:39
 * @description: 搜索插入位置，以及排好序的数组，使用二分查找
 */
public class Code35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        return binarySearch(nums, target, 0, nums.length);
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int len = nums.length;
        if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        }
        return mid;
    }

}
