package cn.caoler.offer;

import cn.caoler.base.ListNode;

import java.util.LinkedList;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 反转链表
 * @date 2020/11/25 2:08 下午
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null, pre = head;

        while (pre != null) {
            //先局部反转
            ListNode tmp = pre.next;
            pre.next = cur;

            //然后把pre、cur都向前挪一位
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}
