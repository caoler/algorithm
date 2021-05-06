package cn.caoler.offerSecond;

public class Offer14I {
    /**
     * 这个题有一个数学推论 ① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 3 。
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        };
        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        //若最后一段绳子长度为 1 ；则应把一份 3 + 1 替换为 2 + 2，因为 2 X 2 > 3 X 1 。
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        //若最后一段绳子长度为 2 ；则保留，不再拆为 1+1
        return (int)Math.pow(3, a) * 2;

    }
}
