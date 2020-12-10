package cn.caoler.offer;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 二叉树的镜像
 * @date 2020/12/10 5:16 下午
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
