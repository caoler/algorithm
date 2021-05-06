package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author keji
 * @desc
 * @date 2021/3/24 3:11 下午
 */
public class LC199 {
    /**
     * BFS
     * 层序遍历，每层最后一个加到list里面去
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    List<Integer> result = new ArrayList<>();

    /**
     * dfs
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth){
        if (root == null) {
            return;
        }
        //每次先来的都是右边节点
        //如果当前的深度等于result的长度，那么就要把当前层放进去，放一次就好了 刚好是吧最右边的放进去了
        if (result.size() == depth) {
            result.add(root.val);
        }
        depth++;
        //先遍历右节点
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
