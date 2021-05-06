package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/25 9:42 下午
 */
public class LC70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public int climbStairs3(int n) {
        int pre = 1;
        int cur = 1;
        int res;
        for(int i = 0; i < n ; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return pre;
    }
}
