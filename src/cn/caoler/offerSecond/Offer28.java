package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        //左右同时为空 那么相同
        if (left == null && right == null) {
            return true;
        }

        //一边为空 或者 值不同，那么不同
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        //左右节点去继续迭代比较
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
