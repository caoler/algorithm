package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

import java.util.Stack;

/**
 * @author keji
 * @desc
 * @date 2021/3/28 6:49 下午
 */
public class LC445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            carry = sum / 10;
            //头插法
            //新建一个节点
            ListNode tmp = new ListNode(sum % 10);

            //把这个节点的next设为head
            tmp.next = head;

            //然后用head把他替换了，最后返回head
            head = tmp;
        }
        return head;
    }
}
