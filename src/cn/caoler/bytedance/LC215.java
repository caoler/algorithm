package cn.caoler.bytedance;

import java.util.PriorityQueue;

/**
 * @author keji
 * @desc
 * @date 2021/3/25 1:20 下午
 */
public class LC215 {
    /**
     * 求最大K  用小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < length; i++) {
            if (i < k) {
                queue.add(nums[i]);
            } else if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
