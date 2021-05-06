package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 6:13 下午
 */
public class LC322 {

    int res = Integer.MAX_VALUE;

    /**
     * 纯递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;

        findWay(coins, amount, 0);

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private void findWay(int[] coins, int amount, int count) {
        //如果上一步减完 这一步小于0了，那么直接返回
        if (amount < 0) {
            return;
        }

        //如果刚好等于0，那么证明减完了，res取最小的
        if (amount == 0) {
            res = Math.min(count, res);
        }

        //挨个遍历
        for (int coin : coins) {
            //往下递归
            findWay(coins, amount - coin, count + 1);
        }
    }


}
