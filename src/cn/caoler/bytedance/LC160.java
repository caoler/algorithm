package cn.caoler.bytedance;

import cn.caoler.base.ListNode;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @author keji
 * @desc
 * @date 2021/4/2 1:41 下午
 */
public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
