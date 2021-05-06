package cn.caoler.base;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 5:54 下午
 */
public class Node {
    public int val;
    public Node next, random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
