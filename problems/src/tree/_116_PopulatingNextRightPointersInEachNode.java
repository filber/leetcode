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
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;
        root.right.next = root.next != null ? root.next.left : null;
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}
