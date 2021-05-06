package cn.caoler.bytedance;

import java.util.Arrays;

/**
 * @author keji
 * @desc 下一个排列
 *
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * @date 2021/3/29 8:34 上午
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {            //找到相邻升序
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {    //从右向左找到最右边第一个大于nums[i-1]的数，并交换
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
                Arrays.sort(nums, i, len);      //将后面降序变为升序
                return;
            }
        }
        Arrays.sort(nums);
    }

}
