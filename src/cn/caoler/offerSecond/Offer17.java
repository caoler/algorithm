package cn.caoler.offerSecond;

public class Offer17 {
    public static int[] printNumbers(int n) {
        int pow = (int)Math.pow(10, n) - 1;

        int[] res = new int[pow];
        for(int i = 0; i < pow; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
