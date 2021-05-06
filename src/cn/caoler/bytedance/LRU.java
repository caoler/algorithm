package cn.caoler.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author keji
 * @desc
 * @date 2021/4/10 7:59 上午
 */
public class LRU {
//
//    private static class Node {
//        int key;
//        int value;
//        Node pre;
//        Node next;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private static class DoubleList {
//        private void addFirst(Node node){
//
//        }
//
//        private Node removeLast() {
//
//        }
//
//        private void remove(Node node) {
//
//        }
//
//        private int size() {
//
//        }
//    }
//
//
//    Map<Integer,Node> map;
//    DoubleList doubleList;
//    int cap;
//
//    public LRU(int cap) {
//        this.cap = cap;
//        this.map = new HashMap<>();
//        this.doubleList = new DoubleList();
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//        Node value = map.get(key);
//        put(key, value.value);
//        return value.value;
//    }
//
//    public void put(int key, int value){
//        Node node = new Node(key,value);
//
//        if(map.containsKey(key)) {
//            doubleList.remove(node);
//            doubleList.addFirst(node);
//            map.put(key, node);
//        } else {
//            if (cap == doubleList.size()) {
//                Node last = doubleList.removeLast();
//                map.remove(last.key);
//            }
//            doubleList.addFirst(node);
//            map.put(key,node);
//        }
//
//    }
}

