package cn.caoler.offer;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
 * 小青蛙跳楼梯
 *
 * @date 2020/11/20 10:47 上午
 */
public class Offer10II {

    public int fibArray(int n) {
        int first = 1;
        int second = 1;
        for (int i = 0; i < n; i++) {
            int third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return second;
    }


}
