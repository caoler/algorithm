package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * 整体思路，结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积。
 * 一轮循环构建左边的乘积并保存在结果集中，
 * 二轮循环 构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
 * @date 2021/3/21 10:29 上午
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];

        int[] b = new int[a.length];
        b[0] = 1;

        for (int i = 1; i < a.length; i++) {
            b[i] = b[i-1] * a[i - 1];
        }

        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
