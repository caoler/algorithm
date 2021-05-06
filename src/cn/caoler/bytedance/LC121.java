package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/25 8:53 上午
 */
public class LC121 {
    /**
     * 暴力
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        //dp来保存当天手上的现金数
        int[][] dp = new int[prices.length][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {

            //今天不持股
            //昨天不持股，今天什么都不做；
            //昨天持股，今天卖出股票（现金数增加）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);

            //今天持股
            //昨天持股，今天什么都不做（现金数与昨天一样）；
            //昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //返回最后一天手上的钱，就是获得的利润
        return dp[length - 1][0];
    }

}
