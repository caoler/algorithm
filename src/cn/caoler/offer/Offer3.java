package cn.caoler.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @date 2020/11/18 3:52 下午
 */
public class Offer3 {

    //暴力 超时
    public static int baoli(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int hash(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                map.put(nums[i],1);
            } else {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int baoli = hash(nums);
        System.out.println(baoli);
    }

}
