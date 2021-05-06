package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/20 9:57 上午
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length == 0) return 0;
        int sum = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            sum = Math.max(sum, prices[i] - low);
        }
        return sum;
    }
}
