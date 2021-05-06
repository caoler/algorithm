package cn.caoler.offerSecond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author keji
 * @desc 题解：https://blog.csdn.net/YouMing_Li/article/details/114521466
 * @date 2021/3/16 7:41 下午
 */
public class Offer38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        char[] charArray = s.toCharArray();
        //这里排序的目的是为了后面 做枝剪
        Arrays.sort(charArray);

        boolean[] market = new boolean[s.length()];
        dfs(res, path, market, charArray);
        return res.toArray(new String[s.length()]);
    }

    private void dfs(List<String> res, StringBuilder path, boolean[] market, char[] charArray) {
        if (path.length() == charArray.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (market[i]) {
                continue;
            }

            //这里来枝剪
            //全排列算法去重条件模板
            //如果这个字符和前一个字符相同且前一个字符还没有用过，continue
            //即我们规定重复字符首次要放入某一个框位时，只能放重复字符的第一个
            //比如a,a',b是可以的，但是a'，a,b和其重复，应该去重，故当要达到产生a',a,b那一层递归栈时
            //由于a'与前一个字符a相同，且a还没有用过，所以continue，这刚好去重，是我们想要的结果
            if (i > 0 && charArray[i] == charArray[i-1] && market[i-1]){
                continue;
            }

            path.append(charArray[i]);

            market[i] = true;

            dfs(res, path, market, charArray);

            //恢复现场
            path.deleteCharAt(path.length() - 1);

            market[i] = false;
        }
    }
}
