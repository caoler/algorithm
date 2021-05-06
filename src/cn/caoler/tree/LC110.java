package cn.caoler.tree;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 4:08 下午
 */
public class LC110 {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
         int left = recur(root.left);
        if (left == -1) {
            return -1;
        }

        int right = recur(root.right);
        if(right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
