package cn.caoler.list;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/reverse-integer/
 * @date 2020/10/15 10:52 上午
 */
public class ReverseInteger {

    /**
     * 如果 rev > intMax / 10 ，那么没的说，此时肯定溢出了。
     * 如果 rev == intMax / 10 = 2147483647 / 10 = 214748364 ，此时 rev * 10 就是 2147483640 如果 pop 大于 7 ，那么就一定溢出了。但是！如果假设 pop 等于 8，那么意味着原数 x 是 8463847412 了，输入的是 int ，而此时是溢出的状态，所以不可能输入，所以意味着 pop 不可能大于 7 ，也就意味着 rev == intMax / 10 时不会造成溢出。
     * 如果 rev < intMax / 10 ，意味着 rev 最大是 214748363 ， rev * 10 就是 2147483630 , 此时再加上 pop ，一定不会溢出。
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            //这里要考虑超出int范围的数字
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

    //先用long去接收 保证不溢出，然后再判断
    public int reverse2(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ) {
            return 0;
        }
        return (int)rev;
    }



    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse2(-77768));
    }
}
