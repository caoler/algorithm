package cn.caoler.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keji
 *
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *

 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]

 *
 * @desc https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * @date 2021/3/24 10:52 上午
 */
public class LC15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums);


        //从一个数的右边开始找
        for (int i = 0; i < len; i++) {
            //如果i 已经大于0了，那么i右边的所有数肯定都大于0了，直接break了
            if (nums[i] > 0) break;

            //如果i和前面的一个数相同 那么跳过
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    //自然增长
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

}
