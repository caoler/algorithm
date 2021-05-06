package cn.caoler.bytedance;

import cn.caoler.base.TreeNode;

import java.util.HashMap;

/**
 * @author keji
 * @desc
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 *
 * @date 2021/3/27 8:19 上午
 */
public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps == pe) return null;
        int rootVal = preorder[ps];

        Integer i_root_index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        //通过inorder划分左右子树
        int leftNum = i_root_index - is;

        root.left = buildTreeHelper(preorder, ps + 1, ps + leftNum + 1, inorder, is, i_root_index, map);
        root.right = buildTreeHelper(preorder, ps + leftNum + 1, pe, inorder, i_root_index + 1, ie, map);

        return root;
    }
}
