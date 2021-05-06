package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 10:24 上午
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
