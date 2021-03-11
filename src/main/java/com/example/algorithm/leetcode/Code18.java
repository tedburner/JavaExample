package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/20 18:51
 * @description: 四数之和
 */
public class Code18 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{1, 0, -1, 0, -2, 2, 0};
        System.out.println(fourSum(nums, -1));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int k = i + 1; k < len; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) continue;
                int left = k + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[k] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    if (sum < target) {
                        left++;
                    }
                    if (sum > target) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
