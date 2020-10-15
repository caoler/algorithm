package cn.caoler.list;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/longest-common-prefix/
 * @date 2020/10/15 4:16 下午
 */
public class LongestCommonPrefix {

    //自己写的方法很笨，循环比较
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }

        int index = -1;
        //先把数组里面这一堆字符串里面最短的找出来
        for (int i = 0; i < strs.length; i++) {
            if (index < 0) {
                index = i;
            } else if (strs[i].length() <= strs[index].length()) {
                index = i;
            }
        }
        int minLength = strs[index].length();

        int i = 0;
        for (; i < minLength; i++) {
            if (!judje(strs,i)) {
                break;
            }
        }
        return strs[0].substring(0,i);
    }

    public boolean judje(String[] strs, int target) {
        char c = ' ';
        for (String str : strs) {
            char[] chars = str.toCharArray();
            char cc = chars[target];

            if (c == ' ') {
                c = cc;
                continue;
            }

            if (cc == c) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"dog","raceaaa","car"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
