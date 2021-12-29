//TOPICS:
//[Tree],[Depth-First Search],[Breadth-First Search]

public class _117_PopulatingNextRightPointersInEachNodeII {
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
        // set left child
        if (root.left!=null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root);
            }
        }

        // set right child
        if (root.right!=null) {
            root.right.next = findNext(root);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private static Node findNext(Node root) {
        if (root.next == null) {
            return null;
        }

        Node next = root.next;
        while (next.next != null) {
            if (next.right != null || next.left != null) {
                break;
            }
            next = next.next;
        }
        return next.left != null ? next.left : next.right;
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
        Node n5 = connect(new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5), null),
                new Node(3,
                        null,
                        new Node(7), null),
                null));
        Node n6 = connect(new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8), null, null),
                        new Node(5),
                        null),
                new Node(3,
                        new Node(6,
                                new Node(9), null, null),
                        new Node(7,
                                new Node(10), null, null),
                        null),
            null));
    }
}
