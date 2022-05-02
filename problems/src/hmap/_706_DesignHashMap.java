package hmap;

//https://leetcode.com/problems/design-hashmap/

public class _706_DesignHashMap {

    public class MyHashMap {

        class Node {
            int key;
            int val;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private static final int SIZE = 100;

        private Node[] nodes = new Node[SIZE];

        public MyHashMap() {
            for (int i = 0; i < SIZE; i++) {
                // dummy head
                nodes[i] = new Node(i, -1);
            }
        }

        public void put(int key, int value) {
            Node pre = searchPre(key);
            if (pre.next != null) {
                pre.next.val = value;
            } else {
                pre.next = new Node(key, value);
            }
        }

        public int get(int key) {
            Node pre = searchPre(key);
            if (pre.next == null) {
                return -1;
            } else {
                return pre.next.val;
            }
        }

        public void remove(int key) {
            Node pre = searchPre(key);
            if (pre.next != null) {
                Node node = pre.next;
                pre.next = node.next;
                node.next = null;
            }
        }

        private Node searchPre(int key) {
            Node pre = nodes[key % SIZE];
            while (pre.next != null && pre.next.key != key) {
                pre = pre.next;
            }
            return pre;
        }
    }
}
