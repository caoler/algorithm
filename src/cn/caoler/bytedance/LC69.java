package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 2:57 下午
 */
public class LC69 {
    public int mySqrt(int x) {
        int res = -1, l = 0, r = x;
        while (l <= r) {
            int mid = (r - l) /2 + l;
            if ((long)mid * mid <= x) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
