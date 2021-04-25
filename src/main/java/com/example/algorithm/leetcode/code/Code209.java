package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/14 23:32
 * @description: 长度最小的子数组
 * 找出连续子子数组 >= target
 */
public class Code209 {

    /**
     * 暴力破解
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int k = i; k < len; k++) {
                sum += nums[k];
                if (sum >= target) {
                    ans = Math.min(k - i + 1, ans);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 滑动窗口
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(11, nums));
    }

}
