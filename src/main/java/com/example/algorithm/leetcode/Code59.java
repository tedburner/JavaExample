package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/16 17:15
 * @description: 螺旋矩阵 II
 */
public class Code59 {

    public static int[][] generateMatrix(int n) {
        int total = n * n;
        int left = 0, top = 0;
        int right = n - 1, low = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        while (total >= 1) {
            //从左往右生成数据
            for (int i = left; i <= right; i++) {
                ans[left][i] = num++;
                total--;
            }
            top++;
            //从上往下生成数据
            for (int i = top; i <= low; i++) {
                ans[i][right] = num++;
                total--;
            }
            right--;
            //从右往左生成数据
            for (int i = right; i >= left; i--) {
                ans[low][i] = num++;
                total--;
            }
            low--;
            //从下网上生成数据
            for (int i = low; i >= top; i--) {
                ans[i][left] = num++;
                total--;
            }
            left++;
        }
        return ans;
    }

}
