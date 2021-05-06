package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 3:58 下午
 */
public class Offer32 {

    //BFS
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);

            if (poll.left != null) {
                queue.add(poll.left);
            }

            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
