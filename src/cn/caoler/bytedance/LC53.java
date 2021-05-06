package cn.caoler.bytedance;

/**
 * @author keji
 *
 * 最大子序和
 * @desc  https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
 *
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 *
 * @date 2021/3/24 2:01 下午
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums) {
            //挨个遍历，如果前面的sum都已经小于0了，那么就不加了，越加越小
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            //拿ans每次记录最大的就好了
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
