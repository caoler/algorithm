package cn.caoler.bytedance;

import cn.caoler.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc
 *
 * 搞一个线性表
 *
 * @date 2021/3/25 7:24 上午
 */
public class LC143 {
    public void reorderList(ListNode head) {
        if (head == null) return;

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            list.get(l).next = list.get(r);
            l++;
            if (l == r) {
                break;
            }
            list.get(r).next = list.get(l);
            r--;
        }
        list.get(l).next = null;
    }




}
