package tree;

//https://leetcode.com/problems/clone-n-ary-tree/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1490_CloneNaryTree {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private Map<Node, Node> map = new HashMap<>();

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node cNode = map.get(root);
        if (cNode != null) {
            return cNode;
        }
        cNode = new Node(root.val);
        map.put(root, cNode);

        for (Node child : root.children) {
            cNode.children.add(cloneTree(child));
        }

        return cNode;
    }
}
