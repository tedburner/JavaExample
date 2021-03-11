package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/14 10:15
 * @description: 数组的相对排序
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 思路：先统计arr1中每个数字出现的次数，然后遍历arr2，处理arr2出现的元素，最后遍历未出现过的元素
 */
public class Code1122 {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int[] ans = new int[len1];
        int[] nums = new int[1001];
        // 统计arr1中每个数字出现的次数
        for (int i : arr1) {
            nums[i]++;
        }
        //遍历arr2，处理出现过的数字
        int index = 0;
        for (int i : arr2) {
            while (nums[i] > 0) {
                ans[index++] = i;
                nums[i]--;
            }
        }
        //遍历nums，处理未出现在arr2中的数字
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0) {
                ans[index++] = i;
                nums[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
