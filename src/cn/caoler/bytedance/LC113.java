package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 2:36 下午
 */
public class LC113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayDeque<>());
        return res;
    }

    private void dfs(TreeNode node, int targetSum, Deque<Integer> path) {
        if (node == null) {
            return;
        }

        if (node.right == null && node.left == null && node.val == targetSum) {
            path.addLast(node.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.addLast(node.val);
        targetSum -= node.val;
        dfs(node.left, targetSum, path);
        dfs(node.right, targetSum, path);
        path.removeLast();
    }
}
