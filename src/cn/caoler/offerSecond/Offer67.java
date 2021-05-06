package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/21 11:11 上午
 */
public class Offer67 {
    public int strToInt(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        int flag = 1;
        if (i < str.length() && str.charAt(i) == '+') i++;
        else if (i < str.length() && str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        long res = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                if (flag == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (flag * res);
    }
}
