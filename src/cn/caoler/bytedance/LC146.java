package cn.caoler.bytedance;

import java.util.HashMap;

/**
 * @author keji
 * @desc 自定义一个双向链表
 * @date 2021/3/24 8:20 上午
 */
public class LC146 {

    private static class Node {
        int key, val;
        Node next, pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 双链表head<->[key,val]<->tail
     */
    private static class DoubleList {
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        // 在链表头部添加节点 x，时间 O(1)

        //也就是把head和n的位置交换了一下
        public void addFirst(Node n) {

            head.next.pre = n;
            n.next = head.next;

            n.pre = head;
            head.next = n;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node res = tail.pre;
            remove(res);
            return res;
        }
    }


    HashMap<Integer, Node> map;
    DoubleList cache;
    int cap;

    public LC146(int cap) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = cap;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);

        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else if (map.size() == cap) {
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(n);
        map.put(key, n);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.val;
    }

}
