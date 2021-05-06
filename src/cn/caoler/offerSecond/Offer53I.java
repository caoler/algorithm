package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 10:36 上午
 */
public class Offer53I {
    public int search(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            if (num == target) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 看到有序就要想到二分
     *
     * https://blog.csdn.net/YouMing_Li/article/details/114657427
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1, left = 0, right = 0;

        //找到小于等于target的最大索引位置
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        right = l;

        //如果数组中并不存在target，直接返回0
        if(nums[right] != target) {
            return 0;
        }

        //找到大于等于target的最小索引位置
        l = 0;
        r = nums.length - 1;
        while(l <r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        left = l;

        return right - left + 1;
    }
}
