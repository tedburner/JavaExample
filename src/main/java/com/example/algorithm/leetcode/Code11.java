package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/31 22:07
 * @description: 盛最多水的容器
 */
public class Code11 {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 2};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int area = 0;
        int x = 0;//水平面积
        int len = height.length;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            x = 0;
            int start = height[i];
            for (int k = i + 1; k < len; k++) {
                end = height[k];
                x++;
                if (start > end) {
                    area = Math.max(area, end * x);
                } else {
                    area = Math.max(area, start * x);
                }
            }
        }
        return area;
    }
}
