package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/16 16:15
 * @description: 根据身高重建队列
 * 题解：按照题目，对于新队列，安装前面人数重新排列，如果出现前面人数相同的情况下，则按照从低到高排列
 * 从高到低，排好序的数组
 * [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
 * 再一个一个插入。
 * [7,0]
 * [7,0], [7,1]
 * [7,0], [6,1], [7,1]
 * [5,0], [7,0], [6,1], [7,1]
 * [5,0], [7,0], [5,2], [6,1], [7,1]
 * [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
 *
 * <p>
 * 解题思路：先排序在插入
 * 1.排序规则：按照先H高度降序，K个数升序排序
 * 2.遍历排序后的数组，根据K插入到K的位置上
 */
public class Code406 {

    public static int[][] reconstructQueue(int[][] people) {
        //数组排序
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);

        List<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
        System.out.println(Arrays.toString(people));

    }
}
