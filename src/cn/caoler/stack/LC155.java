package cn.caoler.stack;

import javafx.scene.chart.ValueAxis;

import java.util.Stack;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 1:22 下午
 */
public class LC155 {

    Stack<Integer> A,B;

    public LC155() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int val) {
        A.add(val);
        if (B.empty() || B.peek() >= val) {
            B.add(val);
        }
    }

    public void pop() {
        if (B.peek().equals(A.pop())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
