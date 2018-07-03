package algorithm.Sort;

/**
 * @author lingjun.jlj
 * @date 2017-12-24
 * 插入排序
 **/
public class InsertSort {

    public static void  InsertSort(int[] arr){
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - (n-1)
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }

    }
}
