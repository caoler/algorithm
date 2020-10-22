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

    /**
     * 用反转法
     *这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     *
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n−k 个元素，就能得到想要的结果。
     *
     *假设 n=7 且 k=3 。
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        reveres(nums,0,length - 1);

        int s = k%length;
        reveres(nums,0,s -1);
        reveres(nums,s,length -1);
    }

    public void reveres(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate1(nums,3);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
