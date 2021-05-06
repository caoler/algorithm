package cn.caoler.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
 * <p>
 * 题解评论第一个
 * @date 2021/3/26 8:00 上午
 */
public class LC20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
