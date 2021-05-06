package cn.caoler.offerSecond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer3 {
    /**
     * 暴力 超时
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * HASH
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i],0);
            } else {
                return nums[i];
            }

        }
        return -1;
    }

    /**
     * 一个萝卜一个坑
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            //如果当前坑位的值不是自己本身，那么就要交换，不然就下一步
            while (nums[i] != i) {
                //如果要交换的坑位已经是人家坑位的值了，那么代表出现重复元素
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

}
