package cn.caoler.offer;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 二进制中1的个数，纯位运算
 * @date 2020/11/24 5:20 下午
 */
public class Offer15 {
    public static int hammingWeight(int n) {
        int num = 0;
        if (n != 0) {
            num += n & 1;
            n >>>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        int i = hammingWeight(n);
        System.out.println(i);
    }
}
