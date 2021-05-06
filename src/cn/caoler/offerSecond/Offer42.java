package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 8:22 上午
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        //遍历
        //若前一个元素大于0，则将其加到当前元素上
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
