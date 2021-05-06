package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/25 9:14 下午
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (right - left) / 2 + left;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeList(l1, l2);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else if (left.val < right.val) {
            left.next = mergeList(left.next, right);
            return left;
        } else {
            right.next = mergeList(left, right.next);
            return right;
        }
    }
}
