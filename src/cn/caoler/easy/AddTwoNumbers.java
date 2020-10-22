package cn.caoler.easy;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/add-two-numbers/
 * @date 2020/10/14 3:43 下午
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        //初始化进位为0
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            //求和，取出来进位
            carry = sum / 10;

            //把余数赋值到next去
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        //如果还有进位，那么把进位直接填到屁股后面去
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
