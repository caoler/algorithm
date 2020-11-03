package cn.caoler.easy;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 3:43 下午
 */
public class SameTree {

    //递归 深度优先搜索
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
