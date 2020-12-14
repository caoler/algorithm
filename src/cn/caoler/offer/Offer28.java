package cn.caoler.offer;

import cn.caoler.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 是否对称二叉树
 */
public class Offer28 {

    /**
     * 直接看 题解，写的很好理解
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
