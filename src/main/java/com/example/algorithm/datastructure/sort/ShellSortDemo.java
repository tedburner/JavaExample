package com.example.algorithm.datastructure.sort;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/7 13:52
 * @description: 希尔排序
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序：将数组分割成若干个子序列，然后在这些子序列中分别进行插入排序，当整个序列基本有序时
     * 再对整体记录进行一次插入排序
     *
     * @param array 待排序数组
     */
    public static void shellSort(int[] array) {
        int i = 0, j = 0;
        int len = array.length;
        do {
            len = len / 3 + 1;
            for (i = len + 1; i < array.length; i++) {
                if (array[i] < array[i - len]) {
                    array[0] = array[i];
                    for (j = i - len; j > 0 && array[0] < array[j]; j -= len) {
                        array[j + len] = array[0];
                    }
                }
            }
        } while (len > 1);
    }
}
