package cn.caoler.offer;

import java.util.LinkedList;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 题解：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dq0t5/
 * @date 2020/11/19 10:37 上午
 */
public class Offer9 {
    /**
     * A负责加入
     * B负责取出
     */
    LinkedList<Integer> A,B;
    public Offer9() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    /**
     * A只负责将值加入栈尾
     * @param value
     */
    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        //如果B不为空，那么直接移除B就行
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        //B为空 并且 A也为空，那么返回出去
        if (A.isEmpty()) {
            return -1;
        }
        //B为空 A不为空
        //把A逆向 转移到B里面去
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
