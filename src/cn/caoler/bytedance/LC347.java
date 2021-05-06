package cn.caoler.bytedance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 8:28 上午
 */
public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (map.get(num) > map.get(heap.peek())) {
                heap.remove();
                heap.add(num);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.remove();
        }
        return res;
    }
}
