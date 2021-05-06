package cn.caoler.medium;

import cn.caoler.base.ListNode;

import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 9:42 下午
 */
public class Lc92 {

    //两编
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;

        //把右边的暂存下来
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;

        leftNode.next = cur;

        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        //pre走到要反转的节点前一位，固定位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;

    }


}
