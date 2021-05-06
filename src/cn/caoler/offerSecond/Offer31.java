package cn.caoler.offerSecond;

import java.util.Stack;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 3:54 下午
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
