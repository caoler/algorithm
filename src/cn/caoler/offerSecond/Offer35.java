package cn.caoler.offerSecond;

import cn.caoler.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 5:54 下午
 */
public class Offer35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            //原节点 -> 新节点
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            //把原来cur的random 给到新节点的random！
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
