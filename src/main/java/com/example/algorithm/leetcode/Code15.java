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
        System.out.println(threeSum(nums));
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
        Map<String, Object> map = new HashMap<>(len);
        for (int i = 0; i < len - 2; i++) {
            for (int k = i + 1; k < len - 1; k++) {
                for (int j = k + 1; j < len; j++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        String key = nums[i] + "_" + nums[k] + "_" + nums[j];
                        if (!map.containsKey(key)) {
                            sumArray.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                            map.put(key, 1);
                        }
                    }
                }
            }
        }
        return sumArray;
    }
}
