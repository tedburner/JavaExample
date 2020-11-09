package com.example.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/9 14:09
 * @description: 最接近原点的 K 个点
 * <p>
 * 思路：排队结果到原点的距离，然后取距离最小的K个数据
 * <p>
 * 重写了Comparator接口中的compare()方法，有两个参数自定义为 o1 和 o2，默认返回0，
 * 如果返回1 ，说明o1>02
 * 如果返回0，说明o1=o2
 * 如果返回-1，说明o1<o2
 */
public class Code973 {

    public static int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        Arrays.sort(points, (point1, point2) -> {
            return point1[0] * point1[0] + point1[1] * point1[1] - (point2[0] * point2[0] + point2[1] * point2[1]);
        });

        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] result = kClosest(points, k);
        System.out.println(Arrays.toString(result));
    }
}
