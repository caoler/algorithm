package cn.caoler.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/two-sum/
 * @date 2020/10/14 3:10 下午
 */
public class TwoSum {

    //1. 暴力，循环list匹配 求和
    public static int[] twoSum1(int[] nums, int target) {
        int args[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    args[0] = i;
                    args[1] = j;
                }
            }
        }
        return args;
    }

    //2. 先把数组放到map里面去，key为值，value为下标
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            //拿到差值，去map里面看看 如果有，并且不是它自己的话 就符合条件
            if (map.containsKey(sub) && map.get(sub) != i) {
                return new int[]{i,map.get(sub)};
            }
        }

        return null;
    }

    //3. 少一次循环
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            //拿到差值，去map里面看看 如果有，并且不是它自己的话 就符合条件
            if (map.containsKey(sub) && map.get(sub) != i) {
                return new int[]{i,map.get(sub)};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(twoSum3(nums, 9)));
    }
}
