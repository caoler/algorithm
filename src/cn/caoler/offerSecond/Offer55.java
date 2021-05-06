package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 2:26 下午
 */
public class Offer55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max(lh, rh) + 1;
    }
}
