package cn.caoler.tree;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 4:03 下午
 */
public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
