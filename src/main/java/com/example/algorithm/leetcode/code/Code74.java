package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/30 16:21
 * @description: 搜索二维矩阵
 */
public class Code74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            // 先判断目标数在哪一行
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                // 这里感觉可以使用二分法进行优化
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};

        System.out.println(searchMatrix(matrix, 1));
    }
}
