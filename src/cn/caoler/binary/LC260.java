package cn.caoler.binary;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 6:51 下午
 */
public class LC260 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int mask = 1;
        while ((sum & mask) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
