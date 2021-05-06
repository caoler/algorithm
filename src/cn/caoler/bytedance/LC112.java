package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 7:37 上午
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
