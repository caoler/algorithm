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

    //前后指针
    //
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head, // 前指针
                latter = head; // 后指针

        //前指针先走k步，保证前后指针中间间隔K格，当前指针往前走走完的时候，那么后指针刚好到倒数第K个位置。！
        for(int i = 0; i < k; i++) {
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
