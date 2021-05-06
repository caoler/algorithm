package cn.caoler.offerSecond;

import java.util.LinkedList;
import java.util.Stack;

public class Offer9 {

    private LinkedList<Integer> A;
    private LinkedList<Integer> B;


    public Offer9() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }

        if (A.isEmpty() && B.isEmpty()) {
            return  -1;
        }

        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
