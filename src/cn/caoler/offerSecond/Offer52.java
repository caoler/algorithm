package cn.caoler.offerSecond;

import cn.caoler.base.ListNode;

import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 10:20 上午
 */
public class Offer52 {
    /**
     * 双指针相遇，太简单了
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
