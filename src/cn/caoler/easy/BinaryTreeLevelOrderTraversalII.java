package cn.caoler.easy;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2020/11/5 5:31 下午
 */
public class BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> levels = new ArrayList<>();

    //正向遍历完  反转list
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);

        Collections.reverse(levels);
        return levels;
    }

    public void helper(TreeNode node, int level) {
        //新开一层的时候先创建一个list
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        //往当前层的list里面把 当前node.val填进去
        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
}
