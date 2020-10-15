package cn.caoler.list;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @date 2020/10/15 11:37 上午
 */
public class StringToInteger {
    public int myAtoi(String s) {

        int sign = 1;
        int ans = 0, pop = 0;
        boolean hasSign = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && !hasSign) {
                sign = -1;
                hasSign = true;
                continue;
            }

            if (s.charAt(i) == '+' && !hasSign) {
                hasSign = true;
                continue;
            }

            if (s.charAt(i) == ' ' && !hasSign) {
                continue;
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasSign = true;
                pop = s.charAt(i) - '0';
                //和上道题判断出界一个意思只不过记得乘上 sign 。
                if (ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7)) {
                    return 2147483647;
                }
                if (ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8)) {
                    return -2147483648;
                }
                ans = ans * 10 + pop;
            } else {
                return ans * sign;
            }
        }

        return ans * sign;
    }
}
