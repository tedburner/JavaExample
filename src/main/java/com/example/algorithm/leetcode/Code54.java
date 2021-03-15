package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/15 23:06
 * @description: 螺旋矩阵
 * 思路，循环遍历二维矩阵，先从左往右，然后从上往下，再从右往左，最后从下网上，循环遍历整个二维数组，
 */
public class Code54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length; // 多少行
        int n = matrix[0].length; // 多少列
        int left = 0, right = n - 1;
        int top = 0, low = m - 1;
        int total = m * n;
        while (total > 0) {
            // 向右遍历
            for (int i = left; i <= right && total >= 1; i++) {
                ans.add(matrix[top][i]);
                total--;
            }
            top++;
            // 最后向下遍历
            for (int i = top; i <= low && total >= 1; i++) {
                ans.add(matrix[i][right]);
                total--;
            }
            right--;
            //最下边往左遍历
            for (int i = right; i >= left && total >= 1; i--) {
                ans.add(matrix[low][i]);
                total--;
            }
            low--;
            //左边从下往上遍历
            for (int i = low; i >= top && total >= 1; i--) {
                ans.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}
