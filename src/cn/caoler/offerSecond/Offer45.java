package cn.caoler.offerSecond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author keji
 * @desc
 * @date 2021/3/17 8:23 下午
 */
public class Offer45 {

    /**
     * 这个题有个很核心的概念，假如有两个字符串ab cd,如果abcd < cdab ,则拼成数字后，abcd也会小于cdab
     * https://blog.csdn.net/YouMing_Li/article/details/114594886
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        list.sort((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1+s2).compareTo(s2 + s1);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
