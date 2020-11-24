package cn.caoler.offer;

/**
 * @author keji
 * @desc 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
 * @date 2020/11/24 5:06 下午
 */
public class Offer14I {
    //数学推导题
    //结论如下：具体推导过程太难，数学能力太差不看了
    //① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为3 。
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        //a为每一段的长度
        int a = n / 3, b = n % 3;
        //b==0代表可以直接被3整除
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        //余数为1
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }
}
