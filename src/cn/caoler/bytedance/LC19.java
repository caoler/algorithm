package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/4/1 6:42 上午
 */
public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
