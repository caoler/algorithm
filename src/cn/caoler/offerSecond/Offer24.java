package cn.caoler.offerSecond;

import cn.caoler.base.ListNode;

import java.util.List;

public class Offer24 {
    //平移 双指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            //暂存
            ListNode tmp = cur.next;
            cur.next = pre;

            //往后平移
            pre = cur;
            cur = tmp;
        }
        //平移到最后，cur指向null了，那么pre就变成头结点了
        return pre;
    }


    /**
     * 不要跳进递归
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

}
