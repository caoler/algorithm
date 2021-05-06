package cn.caoler.offerSecond;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 7:53 上午
 */
public class Offer40 {
    /**
     * 创建大顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        //创建大顶堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

        for (int e : arr) {
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        int j = 0;
        for (Integer e : heap) {
            res[j++] = e;
        }
        return res;
    }

    /**
     * 快排
     * @param arr
     * @param l
     * @param r
     */
    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
