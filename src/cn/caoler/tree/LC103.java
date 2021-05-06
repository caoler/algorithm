package cn.caoler.tree;

import cn.caoler.base.TreeNode;

import java.util.*;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:13 下午
 */
public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int j = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if ((++j & 1) == 0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
