package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/20 10:28 上午
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
