package com.example.algorithm.leetcode.code;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/31 17:16
 * @description: 最后一块石头的重量
 */
public class Code1046 {

    public static int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if (length == 1) {
            return stones[0];
        }
        if (length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        Arrays.sort(stones);
        //如果第三块石头为0，则表明后面的都已经粉碎了
        if (stones[length - 3] == 0) {
            return stones[length - 1] - stones[length - 2];
        }
        //最大的石头减去另一块，然后将另一块设置为0
        stones[length - 1] = stones[length - 1] - stones[length - 2];
        stones[length - 2] = 0;
        return lastStoneWeight(stones);
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
}
