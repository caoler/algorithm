package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/4/2 8:27 上午
 */
public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        return root;
    }
}
