package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc 排序链表
 * @date 2021/3/25 4:32 下午
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next; //快指针
        ListNode slow = head; //慢指针

        //快慢指针，快的到最后一位的时候，慢的正好在中心位置
        if (fast != null && fast.next != null) {
            slow = slow.next; //慢的走一步
            fast = fast.next.next; //快的走两步
        }

        ListNode rightHead = slow.next; //链表后半部分的头结点
        slow.next = null; //切断链表

        //分而治之
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left,right);
    }

    /**
     * 合并两个链表 为有序链表
     * @param h1
     * @param h2
     * @return
     */
    public ListNode merge(ListNode h1,ListNode h2){
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        } else if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }

}
