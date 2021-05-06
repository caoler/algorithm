package cn.caoler.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author keji
 * @desc 字典序遍历
 * @date 2021/3/23 6:30 上午
 */
public class LC386 {
    /**
     * https://leetcode-cn.com/problems/lexicographical-numbers/solution/xian-xu-bian-li-10cha-shu-by-aknifejackzhmolong/
     *
     * 也就是先序遍历10叉树
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> tree = new Stack<>();

        if (n < 10) {
            for (int i = n; i > 0; i--) {
                tree.push(i);
            }
        } else {
            for (int i = 9; i > 0; i--) {
                tree.push(i);
            }
        }

        int t, m;
        while (!tree.isEmpty()) {
            t = tree.pop();
            res.add(t);

            //如果在当前层 那么就不处理了，继续add和continue
            if (t * 10 > n) {
                continue;
            } else {
                //当前层全部遍历完之后，还需要在下一层再遍历m个
                m = n - t * 10;
                if (m > 9) m = 9;
            }

            //把下一层要遍历的push进去
            for (int i = m; i >= 0; i--) {
                tree.push(t * 10 + i);
            }
        }
        return res;
    }

}
