package cn.caoler.offerSecond;

import java.util.HashMap;

/**
 * @author keji
 * @desc
 * @date 2021/3/19 7:08 上午
 */
public class Offer56II {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, false);
            } else {
                map.put(num, true);
            }
        }
        for (int num : nums) {
            if (map.get(num)) {
                return num;
            }
        }
        return -1;
    }
}
