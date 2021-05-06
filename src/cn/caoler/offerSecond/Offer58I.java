package cn.caoler.offerSecond;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/19 8:17 上午
 */
public class Offer58I {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);

    }
}
