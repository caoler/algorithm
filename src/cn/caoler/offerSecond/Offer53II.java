package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 1:51 下午
 */
public class Offer53II {
    /**
     * 直接扔到数组里  看下标是否对应
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;

    }

}
