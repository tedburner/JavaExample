package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/14 21:52
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 思路：因为题目规定时间复杂度O(log n) 级别，所以使用二分法查找定位位置，然后左右查询区间
 */
public class Code34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int length = nums.length;
        if (length == 0) {
            return ans;
        }
        int index = binarySearch(nums, 0, length - 1, target);
        if (index == -1) {
            return ans;
        }
        int left = index;
        int right = index;
        //查询左区间
        while (left >= 0 && nums[left] == target) {
            --left;
        }
        //查询右区间
        while (right < length && nums[right] == target) {
            ++right;
        }
        //多减了
        if (left < 0 || nums[left] != target) {
            left++;
        }
        //多加了
        if (right >= length || nums[right] != target) {
            right--;
        }
        ans[0] = left;
        ans[1] = right;
        return ans;
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param start  左指针
     * @param end    右指针
     * @param target 目标值
     */
    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        }
        return start;
    }

    /**
     * 查询左区间
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //不可以直接返回，需要继续往左边查询边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 查询右区间
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //不可以直接返回，需要继续往右边查询边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right != -1 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 4};
        int[] ans = new Code34().searchRange(nums, 3);
        System.out.println(Arrays.toString(ans));

        int leftIndex = findFirstPosition(nums, 3);
        int rightIndex = findLastPosition(nums, 3);
        System.out.println("数组边界：[" + leftIndex + ", " + rightIndex + "]");
    }
}
