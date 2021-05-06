package cn.caoler.binary;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 5:42 下午
 */
public class LC136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
