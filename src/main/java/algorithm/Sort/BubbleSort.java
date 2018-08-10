package algorithm.Sort;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 冒泡排序
 **/
public class BubbleSort {

    /**
     * 原理：比较两个相邻的元素，将值大的元素交换至右端
     * 平均时间复杂度为：O(n2)
     * 稳定
     * */
    public static void  BubbleSort(int[] arr){
        int i, j;
        int n = arr.length;
        int target;
        for (i = 0; i < n-1 ; i ++){

            for (j = 0 ; j < n-1-i ; j++){
                //左边比右边大
                if (arr[j] > arr[j+1]){
                    target = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = target;
                }
            }
        }
    }
}
