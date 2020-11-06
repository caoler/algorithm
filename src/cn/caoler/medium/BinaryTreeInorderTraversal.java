package cn.caoler.medium;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author keji
 * @desc 94 二叉树的中序遍历
 * @date 2020/11/6 9:56 上午
 */
public class BinaryTreeInorderTraversal {
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);

        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root== null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    //迭代
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);
                curr  =curr.right;
            }
        }
        return result;
    }
}
