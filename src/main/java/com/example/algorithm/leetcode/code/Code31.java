package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/10 15:40
 * @description: 下一个排列
 * 题目解析：
 * 1、先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
 * 2、再找出另一个最大索引 l 满足 nums[l] > nums[k]；
 * 3、交换 nums[l] 和 nums[k]；
 * 4、最后翻转 nums[k+1:]。
 */
public class Code31 {

    public void nextPermutation(int[] nums) {

    }

    public static void main(String[] args) {

    }
}
