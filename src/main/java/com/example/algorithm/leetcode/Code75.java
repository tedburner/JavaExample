package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/9 14:01
 * @description: 颜色分类 <href=https://leetcode-cn.com/problems/sort-colors/ />
 */
public class Code75 {

    /**
     * 单指针: 单指针：先找到0，然后交换位置，然后找到1，交换位置
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }

    /**
     * 双指针：同时进行0和1的查找，如果是0，从前往后的加1，如果是2，从后往前的指针减一
     *
     * @param nums
     */
    public static void sortColorsByDouble(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        int start = 0;
        int i = 0;
        int end = nums.length - 1;
        while (i <= end) {
            int temp = nums[i];
            if (temp == 0) {
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
                i++;
            } else if (temp == 2 && start <= end) {
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
//        System.out.println(nums);
        int[] nums1 = new int[]{2, 0, 2, 1, 1, 0};
        sortColorsByDouble(nums1);
        System.out.println(nums1);
    }
}
