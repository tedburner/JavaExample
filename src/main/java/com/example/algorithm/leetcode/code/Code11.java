package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/31 22:07
 * @description: 盛最多水的容器
 */
public class Code11 {

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 1};
        System.out.println(maxArea(height));
    }

    /**
     * 超时
     *
     * @date:2020-4-14
     */
    public static int maxArea(int[] height) {
        int area = 0; // 面积
        int high; //高
        int i = 0, j = height.length - 1;
        while (i < j) {
            high = Math.min(height[i], height[j]);
            area = Math.max(area, (j - i) * high);
            // 比较柱高，如果低位比高位低，则低位往高位靠近
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }

    /**
     * 第一版代码
     *
     * @date:2019-8-31
     */
    public static int maxAreaV1(int[] height) {
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
