package cn.caoler.offer;

import cn.caoler.base.ListNode;


/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 删除链表的节点
 * @date 2020/11/25 10:04 上午
 */
public class Offer18 {
    //双指针
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        }
        ListNode pre = head, curr = head.next;
        while (curr != null && curr.val != val) {
            curr = curr.next;
            pre = curr;
        }
        if(curr != null) {
            pre.next = curr.next;
        }
        return head;
    }
}
