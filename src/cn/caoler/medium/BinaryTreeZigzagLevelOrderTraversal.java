package cn.caoler.medium;

import cn.caoler.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author keji
 * @desc 不对
 * @date 2020/11/5 10:06 上午
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            boolean even = size / 2 == 0;
            //偶数 先右后左
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (even) {
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                } else {
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
