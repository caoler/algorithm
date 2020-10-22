package cn.caoler.easy;

import cn.caoler.base.ListNode;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @date 2020/10/15 5:47 下午
 */
public class MergeTwoSortedLists {

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 第一步：第一个链表的 第一个节点 和第二个链表的第一个节点作比较，把小的放在最前面，然后题目就变成了：
     * 2->4, 1->3->4
     * 问题不是就又变一样了嘛~
     *
     */

    //坚定不移的相信，本函数可以完成对应目标
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

}
