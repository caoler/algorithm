package cn.caoler.offerSecond;

import java.util.*;

/**
 * @author keji
 * @desc
 * @date 2021/3/19 7:16 上午
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, 1);
        }

        int[] res = new int[2];

        for (int num : nums) {
            if (map.get(target - num) != null) {
                res[0] = num;
                res[1] = target - num;
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i] , nums[j]};
            } if (nums[i] + nums[j] > target){
                j--;
            } else {
                i++;
            }
        }
        return new int[]{0};
    }
}
