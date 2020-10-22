package cn.caoler.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author keji
 * @desc https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date 2020/10/14 4:24 下午
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // 暴力求，遍历字符串，判断长度
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;//保存当前得到满足条件的子串的最大值
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
            {
                //一段一段传进去，取长度

                //false代表还没有重复的，j继续往后循环
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i); //更新 ans
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();//初始化 hash set
        for (int i = start; i < end; i++) {//遍历每个字符
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false; //判断字符在不在 set 中
            }
            set.add(ch);//不在的话将该字符添加到 set 里边
        }
        return true;
    }

    //滑动窗口的形式
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {

            //先去判断当前j位置的字符是否已经存在于set中
            if (!set.contains(s.charAt(j))) {
                //如果不包含，那么把当前的J所在的字符塞到set里面去，顺便自增往后挪
                set.add(s.charAt(j++));
                //取最长的
                ans = Math.max(ans, j - i);
            } else {
                //如果set里面已经存在了，那么j从原来位置继续，但是i往前++一下  重新再循环判断
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //还有通过hash优化的方法，没看懂，就先用这个方法


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters aaa = new LongestSubstringWithoutRepeatingCharacters();
        int jjdhukajj = aaa.lengthOfLongestSubstring2("jjdhukajj");
        System.out.println(jjdhukajj);
    }

}
