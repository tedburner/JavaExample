package com.example.algorithm.leetcode;


import java.util.*;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/2 11:32
 * @description: 三数之和
 */
public class Code15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("三数之和结果:" + threeSum1(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> sumArray = new ArrayList<>();
        return sumArray;
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        System.out.println("原始数据排序后的数据： " + Arrays.toString(nums));
        int len = nums.length;
        List<List<Integer>> sumArray = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            for (int k = i + 1; k < len - 1; k++) {
                for (int j = k + 1; j < len; j++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        sumArray.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                    }
                }
            }
        }
        Set set = new HashSet(sumArray);
        sumArray.clear();
        sumArray.addAll(set);
        return sumArray;
    }
}
