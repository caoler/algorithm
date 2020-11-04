package cn.caoler.medium;

import cn.caoler.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @date 2020/11/3 5:48 下午
 */
public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<>();

    /**
     * 利用队列 广度BFS
     * 这个文章描述的很好
     * https://mp.weixin.qq.com/s?__biz=MzA5ODk3ODA4OQ==&mid=2648167212&idx=1&sn=6af5ffe5b69075b21bb4743ddcee4e7c&chksm=88aa236abfddaa7cae70b42edb299d0a52d9f1cc4fc1fdba1116972fc0ca0275b8bfdf10851b&scene=178&cur_album_id=1338094723818668033#rd
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ret.add(list);
        }

        return ret;
    }

    //递归法 深度DFS
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
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
