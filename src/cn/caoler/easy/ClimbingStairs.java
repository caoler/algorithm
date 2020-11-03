package cn.caoler.easy;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 2:12 下午
 */
public class ClimbingStairs {
    //普通递归
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //记忆法
    public int climbStairs1(int n) {
        int memo[] = new int[n + 1];
        return climbStairsMemo(n,memo);
    }

    public int climbStairsMemo(int n, int[] memo) {
        //如果数组里面已经包含了，那么就再不重复计算了
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[n] = 1;
        } else if (n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairsMemo(n -1 ,memo) + climbStairsMemo(n -2, memo);
        }
        return memo[n];
    }

    //动态规划
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //斐波那契数列 滚动数组法
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int i = climbingStairs.climbStairs3(4);
        System.out.println(i);
    }
}
