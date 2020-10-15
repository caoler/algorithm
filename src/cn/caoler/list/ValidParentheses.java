package cn.caoler.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/valid-parentheses/
 * @date 2020/10/15 5:26 下午
 */
public class ValidParentheses {

    //有问题，没有考虑单独出现的情况，可以AC一部分

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        String str = s.replaceAll(" ", "");

        if (s == null || s.length() == 0) {
            return true;
        }
        if (str.length() % 2 != 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }
        try {
            if (!map.get('(').equals(map.get(')'))) {
                return false;
            }
            if (!map.get('[').equals(map.get(']'))) {
                return false;
            }
            if (!map.get('{').equals(map.get('}'))) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("(]");
        System.out.println(valid);
    }
}
