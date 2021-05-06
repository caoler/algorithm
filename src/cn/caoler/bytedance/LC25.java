package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

import java.util.List;

/**
 * @author keji
 *
 * K 个一组翻转链表
 * 一组一组的反转
 *
 * 画图 看图写
 *
 * @desc https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 * @date 2021/3/24 8:04 上午
 */
public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for(int i = 1; i <= k && end != null; i++) {
                end = end.next;
            }
            if(end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = reverseList(start);
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 1; i <= k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            ListNode start = pre.next;

            end.next = null;
            pre.next = reverseNode2(start);

            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverseNode2(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
