package cn.caoler.offerSecond;

import cn.caoler.base.ListNode;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        int x = length - k + 1;
        if (x == 1) {
            return head;
        }

        int curLength = 1;
        while (curLength != x && cur != null) {
            cur = cur.next;
            curLength ++;
        }
        return cur;
    }
}
