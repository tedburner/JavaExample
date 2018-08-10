package algorithm.Sort;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * @description: 选择排序
 **/
public class SelectionSort {

    /**
     * 第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；
     * 找出最小或者最大的放在下标为0的这个位置。
     * O(N2)
     * 不稳定
     */
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
