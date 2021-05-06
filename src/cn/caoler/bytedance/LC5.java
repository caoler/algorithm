package cn.caoler.bytedance;

/**
 * @author keji
 *
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *
 * @desc https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * @date 2021/3/23 8:46 下午
 */
public class LC5 {
    /**
     * 暴力
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLength = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //如果现在的长度比之前最长的还长  并且 现在的也是回文子串 那么才去更新
                if (j - i + 1 > maxLength && validPalindromic(charArray, i, j)) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    private boolean validPalindromic(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindromeDP(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLength = 1;
        int begin = 0;


        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        //对角线上 单个字符肯定都是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }


    /**
     * 中心扩散 - 看这个就行了
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLength = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < length - 1; i++) {
            //1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
            //
            //2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
            //所以把重合的索引和相邻的都试试  哪个大取哪个
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLengthStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLengthStr.length() > maxLength) {
                maxLength = maxLengthStr.length();
                res = maxLengthStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len){
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        //因为循环里，i和j的值多走了一步，所以i+1是为了起始点减去这一步，而substring方法本就不会包含j,所以j不用减
        return s.substring(i + 1, j);
    }


}
