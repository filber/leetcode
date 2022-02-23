package graph;

import java.util.ArrayList;
import java.util.List;

public class _133_CloneGraph {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    private Node[] nodes = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else if (nodes[node.val] != null) {
            return nodes[node.val];
        }

        Node cNode = new Node(node.val);
        nodes[node.val] = cNode;

        ArrayList<Node> neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            neighbors.add(cloneGraph(neighbor));
        }
        cNode.neighbors = neighbors;

        return cNode;
    }

}
