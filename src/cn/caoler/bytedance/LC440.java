package cn.caoler.bytedance;

import netscape.security.UserTarget;

/**
 * @author keji
 * @desc 两个题解
 * <p>
 * https://blog.nowcoder.net/n/bdfaf75bcf7b4fac8b84dde60597a2c7
 * 算出每个节点的子节点的个数，我们不停的用k减去子节点的个数，当k减到0的时候，当前位置的数字即为所求
 * <p>
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/yi-tu-sheng-qian-yan-by-pianpianboy/
 * @date 2021/3/23 7:38 上午
 */
public class LC440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while(k > 0) {
            int num = getNodeNum(n, cur, cur + 1);
            if (num <= k) {
                k -= num;
                cur += 1;
            } else {
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }

    private int getNodeNum(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            num += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return num;
    }

}
