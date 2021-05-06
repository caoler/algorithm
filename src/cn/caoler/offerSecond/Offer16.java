package cn.caoler.offerSecond;

public class Offer16 {

    /**
     * X的n次方
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = n; i != 0; i /= 2) {
            //如果是奇数，那么要额外乘一下
            if ((i & 1) == 1) {
                result *= x;
            }
            x *= x;
        }

        //如果n是负数  那么转换为 x^(-n) = 1/(x^n)
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }
}
