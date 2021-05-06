package cn.caoler.binary;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 8:45 下午
 */
public class LC338 {
    /**
     * https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num; i++) {
            if ((i & 1) == 0) {
                // 和res[i] = res[i / 2] 的含义一样
                res[i] = res[i >> 1];
            } else  {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
