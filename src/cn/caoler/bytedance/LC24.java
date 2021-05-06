package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 10:27 上午
 */
public class LC24 {
    /**
     * 设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
