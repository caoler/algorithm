package cn.caoler.tree;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:20 下午
 */
public class LC98 {

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
