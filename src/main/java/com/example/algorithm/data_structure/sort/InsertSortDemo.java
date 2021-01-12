package com.example.algorithm.data_structure.sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 插入排序
 **/
public class InsertSortDemo {


    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        InsertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * */
    public static void InsertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i;
            int target = array[i];
            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
        }
    }
}
