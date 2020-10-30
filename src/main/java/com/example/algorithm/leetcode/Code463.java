package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/30 11:04
 * @description: 岛屿的周长
 * <p>
 * 思路：如果碰到1，则周长加4，同时判断当前点位的上左方位是否是1，如果是1，则减去2，即公共的边
 */
public class Code463 {

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    //判断当前点位上方是否是1
                    if (i > 0 && grid[i - 1][j] == 1) {
                        ans -= 2;
                    }
                    //判断左边位置是否是1
                    if (j > 0 && grid[i][j - 1] == 1) {
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }
}
