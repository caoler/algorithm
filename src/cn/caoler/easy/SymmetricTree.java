package cn.caoler.easy;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 5:29 下午
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && symmetric(p.left, q.right) && symmetric(p.right, q.left);
        }
    }
}
