package cn.caoler.offerSecond;

import java.util.Stack;

public class Offer30 {

    //A啥都存，但是B里面 只有遇到比B最顶层还小的值 才往里面存
    Stack<Integer> A,B;

    /** initialize your data structure here. */
    public Offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
