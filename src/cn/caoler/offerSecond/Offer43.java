package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/4/4 3:55 下午
 */
public class Offer43 {
    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0) return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int low = n - high * pow;

        if (high == 1) {
            return f(pow - 1) + 1 + low + f(low);
        } else {
            return high * f(pow - 1) + pow + f(low);
        }
    }
}
