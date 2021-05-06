package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 2:14 下午
 */
public class Offer54 {

    List<Integer> list = new ArrayList<>();

    //中序遍历 默认是排序好的，直接取倒数K个就行了
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        zhongxu(root);
        int size = list.size();
        return list.get(size - k);
    }

    private void zhongxu(TreeNode root){
        if (root == null) {
            return;
        }
        zhongxu(root.left);
        list.add(root.val);
        zhongxu(root.right);
    }

    Queue<Integer> queue = new PriorityQueue<>();

    public int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        zhongxu2(root, k);
        return queue.peek();
    }

    private void zhongxu2(TreeNode root, int k){
        if (root == null) {
            return;
        }
        zhongxu2(root.left, k);

        //先加进去 如果超过限制 再把不合适的弹出来
        queue.offer(root.val);
        if(queue.size() > k){
            queue.poll();
        }

        zhongxu2(root.right, k);
    }

}
