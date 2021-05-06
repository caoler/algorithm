package cn.caoler.stack;

import java.util.Stack;

/**
 * @author keji
 * @desc
 * @date 2021/3/22 1:41 下午
 */
public class LC150 {

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer count = count(token);
                stack.add(count);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    private Integer count(String op) {
        Integer b = stack.pop();
        Integer a = stack.pop();
        if(op.equals("+")) return a + b;
        else if(op.equals("-")) return a - b;
        else if(op.equals("*")) return a * b;
        else return a / b;
    }
}
