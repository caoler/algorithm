package cn.caoler.binary;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 8:32 下午
 */
public class LC191 {
    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += n & 1;
            n >>= 1;
        }
        return sum;
    }
}
