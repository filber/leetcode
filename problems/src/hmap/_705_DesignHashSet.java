package hmap;

//https://leetcode.com/problems/design-hashset/

public class _705_DesignHashSet {

    public class MyHashSet {

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private static final int size = 100;
        Node[] nodes = new Node[size];

        public MyHashSet() {
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i); // dummy node
            }
        }

        private Node searchPre(int key) {
            int id = key % 100;
            Node pre = nodes[id];
            while (pre.next != null && pre.next.val != key) {
                pre = pre.next;
            }
            return pre;
        }

        public void add(int key) {
            Node pre = searchPre(key);
            if (pre.next == null) {
                pre.next = new Node(key);
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

        public boolean contains(int key) {
            Node pre = searchPre(key);
            return pre.next != null;
        }
    }

}
