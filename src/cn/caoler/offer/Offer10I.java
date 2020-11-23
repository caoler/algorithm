package cn.caoler.offer;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @date 2020/11/20 10:47 上午
 */
public class Offer10I {
    /**
     * 超时
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 记忆数组法，解答出错 没想明白
     *
     * @param n
     * @return
     */
    public int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return Memo(n, memo);
    }

    public int Memo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        memo[0] = 0;
        memo[1] = 1;
        memo[n] = Memo(n - 1, memo) + Memo(n - 2, memo);
        return memo[n];
    }

    public int fibDP(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fibArray(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        Offer10I offer10I = new Offer10I();
        int fib = offer10I.fibMemo(45);
        System.out.println(fib);
    }
}
