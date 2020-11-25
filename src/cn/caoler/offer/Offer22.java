package cn.caoler.offer;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 链表中倒数第K个结点
 * @date 2020/11/25 11:34 上午
 */
public class Offer22 {

    /**
     * 一把过
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length ++;
        }
        cur = head;

        int x = length + 1 - k;
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
