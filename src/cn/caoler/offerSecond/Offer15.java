package cn.caoler.offerSecond;

public class Offer15 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            //首先把sum的第一位拿来与1进行【与】运算，   1&1=1，0&1=0 所以可以判断当前位置是不是1
            sum += n & 1;
            //把n右移1位
            n >>>= 1;
        }
        return sum;
    }
}
