package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/19 6:34 下午
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n+1; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
