package cn.caoler.stack;

import cn.caoler.base.TreeNode;

import java.util.*;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 *
 * - 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
 * - 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
 * - 如果遇到的节点为灰色，则将节点的值输出。
 *
 *
 * @date 2021/3/22 3:27 下午
 */
public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));

        while(!stack.empty()){
            ColorNode cn = stack.pop();

            if(cn.color.equals("white")){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
                stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }
        return res;
    }

    public static class ColorNode {
        public TreeNode node;
        public String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<Object> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Object pop = stack.pop();
            if (pop instanceof Integer) {
                res.addLast((Integer) pop);
            } else {
                TreeNode treeNode = (TreeNode) pop;
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                stack.push(treeNode.val);
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }
        }
        return res;
    }

}
