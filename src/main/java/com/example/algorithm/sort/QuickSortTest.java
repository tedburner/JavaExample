package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 快排
 **/
public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 10, 22, 18, 12, 77, 47};
        QuickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void QuickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int high) {

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    int target = array[i];
                    array[i] = array[j];
                    array[j] = target;
                }

            }
        }
    }


}
