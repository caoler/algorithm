package cn.caoler.bytedance;

/**
 * @author keji
 * @desc
 * @date 2021/3/31 7:16 上午
 */
public class LC76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int[] need = new int[128];
        int[] window = new int[128];
        //整型数组存放 Char， Char 的 int 值范围为 0 ~ 127
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        //窗口中已经匹配的字符个数
        int count = 0;

        int minLen = s.length();
        String minStr = "";
        while (right < s.length()) {
            //首先取出字符放到 window里面
            char curChar = s.charAt(right);
            window[curChar]++;
            //如果需要该字符，并且已有窗口里面的字符个数 小于需要的字符个数
            if (need[curChar] > 0 && need[curChar] >= window[curChar]) {
                count++;
            }

            // 当需要的字符都已经包含在窗口中后，开始收缩 left
            while (count == t.length()) {
                curChar = s.charAt(left);

                //从左往右匹配，如果当前字符在need里面，并且window里面包含的数量等于need需要的数量，那么代表这个字符匹配完全了
                //已经匹配的数量减一
                //也就是说当需要删除的字符，是必须留在窗口内时
                if (need[curChar] > 0 && need[curChar] == window[curChar]) {
                    count--;
                }

                if ((right - left + 1) <= minLen) {
                    minLen = right - left + 1;
                    minStr = s.substring(left, right + 1);
                }
                window[curChar]--;
                left++;
            }
            right++;
        }
        return minStr;
    }
}
