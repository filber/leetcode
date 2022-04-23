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
            Node node = search(key);
            if (node == null) {
                node = new Node(key, value);
                // add to head
                node.next = nodes[key % SIZE].next;
                nodes[key % SIZE].next = node;
            } else {
                node.val = value;
            }
        }

        public int get(int key) {
            Node node = search(key);
            return node == null ? -1 : node.val;
        }

        public void remove(int key) {
            Node pre = searchPre(key);
            if (pre.next != null) {
                Node cur = pre.next;
                pre.next = pre.next.next;
                cur.next = null;
            }
        }

        private Node searchPre(int key) {
            Node pre = nodes[key % SIZE];
            while (pre.next != null && pre.next.key != key) {
                pre = pre.next;
            }
            return pre;
        }

        private Node search(int key) {
            Node cur = nodes[key % SIZE].next;
            while (cur != null && cur.key != key) {
                cur = cur.next;
            }
            return cur;
        }
    }
}
