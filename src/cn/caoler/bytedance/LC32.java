package cn.caoler.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author keji
 * @desc 括号匹配
 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-powcai/
 * @date 2021/3/26 6:51 上午
 */
public class LC32 {
    public int longestValidParentheses(String s) {
        if (s== null || s.length() < 2) return 0;

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
