package cn.caoler.list;

import cn.caoler.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 8:54 上午
 */
public class LC234 {
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;

        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }

        int i = 0, j = list.size() - 1;
        while(i < j) {
            if(list.get(i).val == list.get(j).val) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode left = endOfFirstHalf(head);
        ListNode right = reverseList(left.next);

        boolean res = true;
        ListNode p1 = head;
        ListNode p2 = right;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        left.next = reverseList(right);
        return res;
    }



    private ListNode reverseList(ListNode head){
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
}
