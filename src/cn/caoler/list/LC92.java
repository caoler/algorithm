package cn.caoler.list;

import cn.caoler.base.ListNode;

import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 9:39 下午
 */
public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;

        ListNode dum = new ListNode(-1);
        dum.next = head;

        ListNode pre = dum;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;
        return dum.next;

    }

    private void reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
    }
}
