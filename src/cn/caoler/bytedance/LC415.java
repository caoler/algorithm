package cn.caoler.bytedance;

/**
 * @author keji
 * @desc 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * @date 2021/4/1 7:24 上午
 */
public class LC415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0) {
            int m = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = m + n + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;j--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
