package list;

//https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node copy = map.get(head);
        if (copy == null) {
            copy = new Node(head.val);
            map.put(head, copy);
            copy.next = copyRandomList(head.next);
            copy.random = copyRandomList(head.random);
        }
        return copy;
    }
}
