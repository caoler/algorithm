package cn.caoler.tree;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:28 下午
 */
public class LC701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
