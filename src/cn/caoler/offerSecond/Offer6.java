package cn.caoler.offerSecond;

import cn.caoler.base.ListNode;

import java.util.List;
import java.util.Stack;

public class Offer6 {
    /**
     * 遍历 反向存进去
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int depth = 0;
        ListNode currNode = head;
        while (currNode != null) {
            depth++;
            currNode = currNode.next;
        }
        currNode = head;
        int[] result = new int[depth];
        while (currNode != null) {
            result[depth - 1] = currNode.val;
            depth--;
            currNode = currNode.next;
        }
        return result;
    }


    /**
     * 推入栈
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp  = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}
