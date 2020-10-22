package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/single-number/
 * @date 2020/10/22 2:13 下午
 */
public class SingleNumber {
    /**
     * 用异或方法做，直接看题解吧
     *
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
