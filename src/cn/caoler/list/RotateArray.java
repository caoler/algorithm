package cn.caoler.list;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/rotate-array/
 * @date 2020/10/22 11:40 上午
 */
public class RotateArray {
    /**
     * 自己想的
     * 按照原始数组每个位置的数字，算出他的新下标，创建一个新数组放进去
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        if (k > length) {
            k = k % length;
        }
        int[] res = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + k;

            if (j < length) {
                res[j] = nums[i];
            } else {
                res[j - length] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums,3);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
