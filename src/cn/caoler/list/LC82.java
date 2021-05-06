package cn.caoler.list;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:43 下午
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dum = new ListNode(-1);
        dum.next = head;
        head = dum;


        int n;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                n = head.next.val;
                while (head.next != null && head.next.val == n) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dum.next;
    }
}
