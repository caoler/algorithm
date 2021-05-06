package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

import java.util.*;

/**
 * @author keji
 * @desc
 * @date 2021/3/26 3:31 下午
 */
public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode poll = queue.poll();
                //如果%2==0 那么代表这一层是奇数,原来列表是偶数 那么这一层就是奇数
                if (res.size() % 2 == 0) {
                    list.addLast(poll.val);
                } else {
                    list.addFirst(poll.val);
                }

                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }

}
