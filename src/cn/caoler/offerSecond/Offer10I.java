package cn.caoler.offerSecond;

public class Offer10I {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fibMemo(int n) {
        int[] memo = new int[n+1];
        return memo(memo, n);
    }

    private int memo(int[] memo, int n) {
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
        memo[n] = memo(memo,n - 1) + memo(memo, n - 2);
        return memo[n];
    }

    public int fib3(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
