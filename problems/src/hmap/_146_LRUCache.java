package hmap;

//https://leetcode.com/problems/lru-cache/

public class _146_LRUCache {

    public static class LRUCache {

        class Node {
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public int key;
            public int val;
            public Node prev;
            public Node next;
        }

        private final int capacity;
        private final Node[] map;
        private final Node dummyHead, dummyTail;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new Node[10001];
            this.dummyHead = new Node(0, 0);
            this.dummyTail = new Node(0, 0);
            this.dummyHead.next = dummyTail;
            this.dummyTail.prev = dummyHead;
        }

        private void add(Node node) {
            node.prev = dummyHead;
            node.next = dummyHead.next;
            node.next.prev = node;
            dummyHead.next = node;
        }

        private Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        public int get(int key) {
            Node node = map[key];

            if (node == null) return -1;

            add(remove(node));
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map[key];

            if (node != null) {
                add(remove(node));
                node.val = value;
            } else {
                node = new Node(key, value);
                map[key] = node;
                add(node);

                if (++size > capacity) {
                    map[dummyTail.prev.key] = null;
                    remove(dummyTail.prev);
                }
            }
        }
    }
}
