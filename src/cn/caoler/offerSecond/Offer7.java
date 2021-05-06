package cn.caoler.offerSecond;

import cn.caoler.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/4/20 7:55 上午
 */
public class Offer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pre_start, int pre_end,
                                     int[] inorder, int in_start, int in_end, Map<Integer,Integer> map) {
        if(pre_start == pre_end) return null;
        int rootVal = preorder[pre_start];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);
        int left = rootIndex - in_start;

        root.left = buildTreeHelper(preorder, pre_start + 1, pre_start + left + 1,
                inorder, in_start, rootIndex, map);
        root.right = buildTreeHelper(preorder, pre_start + left + 1, pre_end,
                inorder, rootIndex + 1, in_end, map);
        return root;
    }
}
