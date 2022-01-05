package tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//TOPICS:
//[Tree],[Depth-First Search],[Breadth-First Search]

//TIPS:
//Construct all links of children before recurse down them.
public class _116_PopulatingNextRightPointersInEachNode {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left!=null) {
            root.left.next = root.right;
            if (root.next!=null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.right);
        connect(root.left);
        return root;
    }

    public static Node connectBFS(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        if (root.right != null) {
            queue.add(root.right);
            queue.add(root.left);
        }

        Node previous = null;
        int cnt = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            if (cnt + 1 == (int) (Math.pow(2, level))) {
                // tail of this level
                head.next = null;
                level++;
            } else {
                head.next = previous;
            }
            if (head.right != null) {
                queue.add(head.right);
                queue.add(head.left);
            }
            previous = head;
            cnt++;
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1 = connect(null);
        Node n2 = connect(new Node(1,null,null,null));

        Node n3 = connect(new Node(1,
                new Node(2,null,null,null),
                new Node(3,null,null,null),
                null));
        Node n4 = connect(new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        new Node(6),
                        new Node(7), null),
                null));
    }
}
