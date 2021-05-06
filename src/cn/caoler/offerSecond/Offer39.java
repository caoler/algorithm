package cn.caoler.offerSecond;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 8:37 下午
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int harf = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            Integer integer = map.get(nums[i]);
            if (integer != null) {
                count = integer;
            }

            if (count == harf) {
                return nums[i];
            } else {
                map.put(nums[i], ++count);
            }
        }
        return -1;
    }
}
