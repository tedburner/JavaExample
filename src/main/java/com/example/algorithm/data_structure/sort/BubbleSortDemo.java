package com.example.algorithm.data_structure.sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 冒泡排序
 **/
public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        BubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 原理：比较两个相邻的元素，将值大的元素交换至右端
     * 平均时间复杂度为：O(n2)
     * 稳定
     * 比较：相邻2个元素比较大小
     */
    public static void BubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int target = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = target;
                }
            }
        }
    }
}
