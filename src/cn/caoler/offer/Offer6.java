package cn.caoler.offer;

import cn.caoler.base.ListNode;

import java.util.Stack;

/**
 * @author keji
 * @desc
 * @date 2020/11/18 4:45 下午
 */
public class Offer6 {
    public int[] reversePrint(ListNode head) {
        ListNode currNode = head;
        int len = 0;
        //先遍历，把数组长度求出来
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再遍历 反向填充数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }

    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

}
