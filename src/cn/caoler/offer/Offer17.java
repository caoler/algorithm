package cn.caoler.offer;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *  从 1 至最大的 n 位数的列表
 * @date 2020/11/25 9:58 上午
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10,n) - 1;
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
