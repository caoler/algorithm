package cn.caoler.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author keji
 * @desc  全排列
 *
 * 涉及重复的看剑指offer38
 * @date 2021/3/25 3:01 下午
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        //用来存储此次递归的某个位置是否已经有值了
        boolean[] used = new boolean[len];
        //暂存当前排列
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        //如果是当前层是最后一层，那么直接add进去
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            //如果该位置还没有填进去值  那么进去
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
            }
        }
    }


}
