package cn.caoler.offer;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Offer32I {
    List<Integer> list = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.addAll(list.get(i));
        }

        //把list转化为数组
        int[] res = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            res[i] = tempList.get(i);
        }
        return res;
    }

    public void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null)
            return;
        //新建一层
        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(root.val);
        levelHelper(list, root.left, height + 1);
        levelHelper(list, root.right, height + 1);
    }
}
