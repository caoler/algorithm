package cn.caoler.sort;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 7:42 下午
 */
public class QuickSort {
    static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        //首先取最左侧的为基准值
        int i = l, j = r;
        while (i < j) {

            //从右向左，如果最右侧的值 大于基准值，那么就跳过，直到找到一个比基准值小的
            while (i < j && array[l] <= array[j]) {
                j--;
            }
            //从左向右遍历，如果当前值小于基准值 那么向右继续遍历 直到找到一个比基准值大的
            while (i < j && array[l] >= array[i]) {
                i++;
            }

            //这个时候，j比基准值小，i比基准值大，那么把i和j交换了
            swap(array, i, j);
        }

        //i和j重复了，那么把当前位置和基准值交换了
        swap(array, l, i);

        //原来基准值现在在i的位置，i左边就是比i小的，i右边就是比i大的
        //那么继续左边和右边小段的继续递归排序
        quickSort(array, l, i - 1);
        quickSort(array, i + 1, r);
    }


    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 5, 6, 4};
        quickSort(array, 0, 5);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
