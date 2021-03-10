package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/20 17:35
 * @description: 最接近的三数之和
 */
public class Code16 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        System.out.println(threeSumClosest(nums, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        if (nums.length <= 3) {
            for (int num : nums) {
                ans += num;
            }
            return ans;
        }
        Arrays.sort(nums);
        ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target) {
                    left++;
                }else if (sum > target) {
                    right--;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
