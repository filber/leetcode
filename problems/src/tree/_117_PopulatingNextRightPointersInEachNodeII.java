package tree;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.ArrayDeque;
import java.util.Queue;

public class _117_PopulatingNextRightPointersInEachNodeII {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Node pre = null;
            for (int i = 0; i < sz; i++) {
                Node node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                pre = node;
            }
        }

        return root;
    }
}
