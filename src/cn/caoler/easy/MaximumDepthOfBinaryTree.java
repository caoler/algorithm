package cn.caoler.easy;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;

/**
 * @author keji
 * @desc
 * @date 2020/11/5 10:28 上午
 */
public class MaximumDepthOfBinaryTree {

    int level = 0;

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return level;
//        }
//
//        helper(root, 1);
//        return level;
//    }
//    public void helper(TreeNode node, int level) {
//        if (node.left != null) {
//            helper(node.left, ++level);
//        }
//        if (node.right != null) {
//            helper(node.right, ++level);
//        }
//    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
