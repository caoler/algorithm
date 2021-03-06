package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/remove-element/
 * @date 2020/10/16 11:17 上午
 */
public class RemoveElement {

    /**
     * 前后指针
     * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j] ！= val
     * 我们就复制 nums[j]到 nums[i] 并同时递增两个索引。重复这一过程，直到 j 到达数组的末尾，该数组的新长度为i。
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
