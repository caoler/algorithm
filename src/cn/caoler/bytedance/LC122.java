package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/2 9:11 上午
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //当天不持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
