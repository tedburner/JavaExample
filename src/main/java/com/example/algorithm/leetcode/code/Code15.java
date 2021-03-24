package com.example.algorithm.leetcode.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/2 11:32
 * @description: 三数之和
 */
public class Code15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        long start1 = System.currentTimeMillis();
        System.out.println("三数之和结果:" + threeSum(nums));
        System.out.println("耗时：" + (System.currentTimeMillis() - start1) + "ms");
        long start2 = System.currentTimeMillis();
        System.out.println("三数之和——暴力求解结果:" + threeSum1(nums));
        System.out.println("耗时：" + (System.currentTimeMillis() - start2) + "ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        //从小到大排序，如果首位的数大于0，则肯定不存在三数和为0的
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            int left = i + 1, right = len - 1;
            //去重数据
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
            }
        }
        return ans;
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int k = i + 1; k < len - 1; k++) {
                for (int j = k + 1; j < len; j++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                    }
                }
            }
        }
        Set set = new HashSet(ans);
        ans.clear();
        ans.addAll(set);
        return ans;
    }
}
