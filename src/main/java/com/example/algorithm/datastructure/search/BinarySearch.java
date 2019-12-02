package com.example.algorithm.datastructure.search;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/9 15:37
 * @description: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7};
        System.out.println(binarySearch(nums, 3, 0, nums.length));
    }

    /**
     * 二分查找
     *
     * @param nums   有序数组
     * @param target 目标数
     * @param left   做下标
     * @param right  右下标
     * @return 下标
     */
    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
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


    /**
     * 二分查找
     *
     * @param nums   有序数组
     * @param target 目标数
     * @return 下标
     */
    public static int binarySearch(int[] nums, int target) {
        return 0;
    }
}
