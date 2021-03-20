package com.example.algorithm.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/12 10:37
 * @description: 删除排序数组中的重复项
 */
public class Code26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println("删除重复项后的新数组长度：" + len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        List<Integer> container = new ArrayList<>();
        int[] array = nums;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //判断容器中是否存在当前元素
            if (!container.contains(array[i])) {
                container.add(array[i]);
            }
        }
        for (int i = 0; i < container.size(); i++) {
            nums[i] = container.get(i);
        }
        return container.size();
    }
}
