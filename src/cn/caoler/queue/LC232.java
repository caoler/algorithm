package cn.caoler.queue;

import java.util.Stack;

/**
 * @author keji
 * @desc
 *
 * 我们不妨将所有元素都时刻保存在栈 b 中，也即任何操作过后，要保证全部元素保存在栈 b 中。需要模拟的操作如下：
 *
 * 模拟元素“入队”时，要从队尾入队，也即要压入栈 a，但在此之前要先把栈 b 中的所有元素放入 a 中，压栈后再将 a 中元素再放回 b 中；
 *
 * 模拟元素“出队”时，要从队头出队，也即从 b 的栈顶弹出元素。
 *
 * 模拟 top/pop 操作时，类似元素“出队”操作，由于全部元素时刻保存在栈 b 中，所以只需对栈 b 进行取栈顶操作或弹出栈顶元素操作即可。
 *
 * @date 2021/3/22 5:06 下午
 */
public class LC232 {

    /**
     * 通俗的讲就是
     * A只有在push元素的时候用，B用来存所有元素
     *
     * push的时候，先把B的所有元素一个个取出来，放到A里面，也就是把B里面的所有东西换了个方向，接着往屁股后面把新元素加进来
     *
     * 然后B空了
     *
     * 再把A里面的所有元素一个个放到B里面
     *
     * pop peek empty函数直接判断B就行了
     */

    Stack<Integer> a, b;
    public LC232() {
        a = new Stack();
        b = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!b.isEmpty()) {
            a.push(b.peek());
            b.pop();
        }
        a.push(x);
        while(!a.isEmpty()) {
            b.push(a.peek());
            a.pop();
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return b.empty();
    }
}
