package cn.caoler.easy;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/implement-strstr/
 * @date 2020/10/19 2:35 下午
 */
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String hay = "aaahhbj";
        String nel = "hbj";
        ImplementStr implementStr = new ImplementStr();
        int i = implementStr.strStr(hay, nel);
        System.out.println(i);
    }
}
