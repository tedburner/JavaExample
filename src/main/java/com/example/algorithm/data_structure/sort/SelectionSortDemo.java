package com.example.algorithm.data_structure.sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 选择排序
 **/
public class SelectionSortDemo {

    public static void main(String[] args) {
        int[] arry = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        SelectionSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    /**
     * 第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；
     * 找出最小或者最大的放在下标为0的这个位置。
     * O(N2)
     * 不稳定
     * 比较：比较元素，把最小的元素放在应该的位置
     */
    public static void SelectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int target = array[i];
                    array[i] = array[j];
                    array[j] = target;
                }
            }
        }
    }
}
