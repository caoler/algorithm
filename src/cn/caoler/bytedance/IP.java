package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/4/13 10:36 上午
 */
public class IP {
    public int GetSteps(int n,int k){
        if(n==0) return 1;
        if(n==2){
            if(k%2==0) return 1;
            else return 0;
        }
        int[][] dp = new int[k+1][n];
        dp[0][0]=1;
        for(int j=1;j<=k;j++){
            for(int i=0;i<n;i++){
                dp[j][i]=dp[j-1][(i-1+n)%n]+dp[j-1][(i+1)%n];
            }
        }
        return dp[k][0];
    }
}
