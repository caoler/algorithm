package cn.caoler.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 5:44 下午
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])){
                return nums[i];
            }
        }
        return 0;
    }
}
