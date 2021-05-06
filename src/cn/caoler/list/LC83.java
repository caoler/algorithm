package cn.caoler.list;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 8:37 下午
 */
public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
