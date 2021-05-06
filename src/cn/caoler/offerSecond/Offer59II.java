package cn.caoler.offerSecond;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author keji
 * @desc 使用一个辅助队列
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 * @date 2021/3/19 7:36 下午
 */
public class Offer59II {

    Deque<Integer> res, max;

    public Offer59II() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.peekFirst();

    }

    public void push_back(int value) {
        res.add(value);
        while (!max.isEmpty() && max.peekFirst() < value) {
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (res.isEmpty()) return -1;
        int tmp = res.peekFirst();
        if (tmp == max.peekFirst()) max.removeFirst();
        res.removeFirst();
        return tmp;
    }
}
