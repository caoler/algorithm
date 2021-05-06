package cn.caoler.offerSecond;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/3/18 9:57 上午
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            if (map.get(c)) return c;
        }
        return ' ';
    }


}
