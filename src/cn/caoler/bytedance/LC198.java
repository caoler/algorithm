package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 10:44 上午
 */
public class LC198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[n] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n];
    }
    public int rob2(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int tmp = Math.max(cur, pre + num);
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
