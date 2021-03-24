package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/12 10:52
 * @description: 移除元素
 */
public class Code27 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int val = 1;
        int len = removeElement(nums, val);
        System.out.println("删除指定元素后的新数组长度：" + len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        return size;
    }
}
