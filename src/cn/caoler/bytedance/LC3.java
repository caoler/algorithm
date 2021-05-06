package cn.caoler.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @date 2021/3/23 5:45 下午
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int sum = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            sum = Math.max(sum, end - start + 1);
            map.put(c, end + 1);
        }
        return sum;
    }
}
