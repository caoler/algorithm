package cn.caoler.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 7:17 下午
 */
public class LC128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        //从小到大找
        for (Integer num : set) {
            //往下没有了的时候
            if (!set.contains(num - 1)) {
                int cur = num;
                int curRes = 1;

                //开始往上找 累加curRes
                while (set.contains(cur + 1)) {
                    cur++;
                    curRes++;
                }
                res = Math.max(curRes, res);
            }
        }
        return res;
    }
}
