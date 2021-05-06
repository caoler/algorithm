package cn.caoler.list;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:51 下午
 */
public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList2(head);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
