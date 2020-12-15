package cn.caoler.offer;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Offer34 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode root, int tar) {
        if (root == null) return;

        //直接把当前节点先加到path中
        int val = root.val;
        path.add(val);
        //目标值--
        tar = tar - val;

        //如果当前节点已经是叶子节点了，并且目标值刚好减为0了，那么 当前的path就是符合条件的
        if (root.left == null && root.right == null && tar == 0) {
            res.add(new LinkedList(path));
        }

        //根左右遍历
        recur(root.left, tar);
        recur(root.right, tar);
        //如果不符合条件，那么把当前节点移除，回退至上一层
        path.removeLast();
    }
}
