package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 4:20 下午
 */
public class Offer32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(list);
        }
        return res;
    }
}
