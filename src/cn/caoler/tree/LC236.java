package cn.caoler.tree;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 4:27 下午
 */
public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
