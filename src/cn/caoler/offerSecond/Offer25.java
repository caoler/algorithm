package cn.caoler.offerSecond;

import cn.caoler.base.ListNode;

public class Offer25 {
    /**
     * 迭代 新建的dum链表  先初始化头结点为0，然后把l1 l2往后面拼接
     * 最后返回dum.next就行了
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        return recur(l1, l2);
    }

    private ListNode recur(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;

        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            head.next = recur(l1.next, l2);
        } else {
            head = new ListNode(l2.val);
            head.next = recur(l1, l2.next);
        }

        return head;


    }
}
