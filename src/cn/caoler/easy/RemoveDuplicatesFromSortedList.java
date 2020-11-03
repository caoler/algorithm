package cn.caoler.easy;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2020/11/3 2:58 下午
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
