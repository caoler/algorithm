package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

public class Offer26 {
    /**
     * 遍历A，找到B的头结点
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        if (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是不是子树
     * @param A
     * @param B
     * @return
     */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
