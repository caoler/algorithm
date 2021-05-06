package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/23 10:41 上午
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            //保存进位
            carry = sum / 10;
            //获得余数
            sum %= 10;

            //当前算出来的值 加到cur后面
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //如果有进位  那么再往后面拼一个
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}
