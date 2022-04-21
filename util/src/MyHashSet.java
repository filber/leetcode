
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
    }

    public void add(int key) {
        int idx = key % size;
        if (nodes[idx] == null) {
            nodes[idx] = new Node(key);
            return;
        }
        Node pre = null;
        Node cur = nodes[idx];
        while (cur != null && cur.val != key) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null && pre != null) {
            // reach the end of the list and didn't find key
            // add to the end
            pre.next = new Node(key);
        }
    }

    public void remove(int key) {
        int idx = key % size;
        if (nodes[idx] == null) {
            return;
        }
        Node pre = null;
        Node cur = nodes[idx];
        while (cur != null && cur.val != key) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
            // find key
            if (pre == null) {
                // delete head node
                nodes[idx] = nodes[idx].next;
            } else {
                pre.next = cur.next;
            }
            cur.next = null; // prevent memory leak
        }
    }

    public boolean contains(int key) {
        int idx = key % size;
        if (nodes[idx] == null) {
            return false;
        }
        Node cur = nodes[idx];
        while (cur != null && cur.val != key) {
            cur = cur.next;
        }

        return cur != null;
    }
}
