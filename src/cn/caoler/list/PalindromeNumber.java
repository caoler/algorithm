package cn.caoler.list;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/palindrome-number/
 * @date 2020/10/15 3:50 下午
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int rev = reverse(x);
        return rev == x;
    }

    //反转
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }
}
