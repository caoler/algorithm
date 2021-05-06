package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * 看评论
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
 * @date 2021/4/1 7:53 上午
 */
public class LC543 {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = depth(root.left);
        int rightMax = depth(root.right);
        max = Math.max(leftMax + rightMax, max);
        return Math.max(leftMax,rightMax) + 1;
    }
}
