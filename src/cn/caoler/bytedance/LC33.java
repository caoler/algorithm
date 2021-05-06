package cn.caoler.bytedance;

/**
 * @author keji
 * @desc 二分查找
 * @date 2021/3/25 6:58 上午
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return mid;

            //456123
            //左边有序
            if (nums[l] <= nums[mid]) {
                //目标值在左
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                //右边有序
            } else {  //56701234
                //目标值在右
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
