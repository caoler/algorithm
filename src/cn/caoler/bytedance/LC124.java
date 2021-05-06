package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/24 9:18 下午
 */
public class LC124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     * 返回经过root的单边分支最大和， 即Math.max(root, root+left, root+right)
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int leftMax = Math.max(0, dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0, dfs(root.right));
        //left->root->right 作为路径与已经计算过历史最大值做比较
        max = Math.max(max, root.val + leftMax + rightMax);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(leftMax, rightMax);
    }

    /**
     * 关于返回值
     * 将题目的问题拆分为：遍历每个节点，max{从左到右穿过当前节点的最大路径和}。
     *
     * 子问题：就是当前节点求解“从左到右穿过当前节点的最大路径和”，就必须知道左右子树穿过各自根节点的“单边路径”。
     *
     * 遍历一遍二叉树，用这个子问题的答案与全局max对比更新一下。
     *
     * 将题目问题拆解为：遍历每个节点，求穿过当前节点的最长路径 -> 根据题意进一步转化为：求当前节点左右深度之和。
     *
     * 在求解子问题时，就必须知道左右子树的深度，才能求解深度之和。
     */

}
