package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 4:47 下午
 */
public class Offer55II {
    public boolean isBalanced(TreeNode root) {
        //前序遍历每一个节点，判断当前节点左右子树的深度相差是否不超过1
        if(root == null) {
            return true;
        }
        if(Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if(root == null) {
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
