package cn.caoler.list;

import cn.caoler.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 7:36 上午
 */
public class LC143 {
    /**
     * 线性表
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }

    public void reorderList2(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        rightHead = reverseList(rightHead);

        mergeList(slow,rightHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 合并两个链表  不用管顺序
     * @param l1
     * @param l2
     */
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

}
