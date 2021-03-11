package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/17 10:26
 * @description: 缀点成线
 * 斜率：(y2 - y1) / (x2 - x1) == (y3 - y2) / (x3 - x2)
 * 公式转化：(x2 - x1) * (y3 - y2) == (y2 - y1) * (x3 - x2)
 * 通过判断直线K的斜率是否一致相等
 */
public class Code1232 {

    public static boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i + 1 < coordinates.length; i++) {
            int n = (coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i + 1][1] - coordinates[i][1]);
            int m = (coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i + 1][0] - coordinates[i][0]);
            if (n != m) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));
    }
}
