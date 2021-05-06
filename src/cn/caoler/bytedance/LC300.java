package cn.caoler.bytedance;

import java.util.Arrays;

/**
 * @author keji
 * @desc  https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 *
 *
 * @date 2021/3/28 2:50 下午
 */
public class LC300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        //dp[i]代表nums前i个数字的最长子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                //因为j < i ，所以是dp[j] + 1
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
