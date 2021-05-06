package cn.caoler.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keji
 * @desc 括号生成
 *
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * @date 2021/3/30 10:02 下午
 */
public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        dfs("",n, n, res);

        return res;
    }

    private void dfs(String s, int left, int right, List<String> res) {

        //如果左右都为0了，那么代表到头了
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        //左边的数量如果比右边的多，那么代表右边先进去了，那么不可能组成括号
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(s + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(s + ")", left, right - 1, res);
        }
    }
}
