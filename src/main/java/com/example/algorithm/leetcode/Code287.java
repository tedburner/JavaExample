package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/20 16:42
 * @description: 寻找重复数
 * 思路一：排序后，遍历前后两个数据是否一致，如果一致，返回这个数
 * 思路二：在不改变原来数组的情况下，使用快慢指针，
 */
public class Code287 {

    /**
     * 排序遍历 easy
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (pre == nums[i]) {
                return pre;
            }
            pre = nums[i];
        }
        return pre;
    }

    /**
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     * 即按照寻找链表环入口的思路来做
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[fast];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));

    }
}
