package cn.caoler.offer;

import cn.caoler.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从上到下打印二叉树iii
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class Offer32III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.addAll(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if ((i+1)%2 == 0) {
                Collections.reverse(list.get(i));
            }
        }

        return list;
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
