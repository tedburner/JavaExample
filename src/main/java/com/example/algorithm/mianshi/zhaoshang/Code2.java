package com.example.algorithm.mianshi.zhaoshang;

import java.util.*;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/10 10:46
 * @description: 招商银行笔试2
 */
public class Code2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        //分割子集合
        Set<List<Integer>> list = subsets(nums);
        System.out.println(list.size());

    }

    public static Set<List<Integer>> subsets(int[] nums) {
        int target = 24;
        List<Integer> t = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    t.add(nums[i]);
                }
            }
            if (sum == target) {
                ans.add(new ArrayList<>(t));
            }
        }
        return ans;
    }
}
