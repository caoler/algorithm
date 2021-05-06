package cn.caoler.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author keji
 * @desc
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 *
 * s
 *
 *
 * @date 2021/4/2 7:25 上午
 */
public class LC739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int cur = T[i];
            for (int j = i + 1; cur < 100 && j < T.length; j++) {
                if (T[j] > cur) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = T.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekLast()]) {
                Integer pre = stack.removeLast();
                res[pre] = i - pre;
            }
            stack.addLast(i);
        }
        return res;
    }
}
