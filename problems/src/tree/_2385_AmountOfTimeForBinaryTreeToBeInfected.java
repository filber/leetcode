package tree;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

import java.util.*;

public class _2385_AmountOfTimeForBinaryTreeToBeInfected {

    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public int amountOfTimeBFS(TreeNode root, int start) {
        // convert root tree to graph
        dfs(root);

        // BFS
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int distance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int nextNode = queue.poll();
                for (int neighbor: graph.get(nextNode)) {
                    if (!visited.contains(nextNode)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance ++;
        }

        return distance;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        Set<Integer> edges = graph.computeIfAbsent(val, k -> new HashSet<>());
        if (root.left != null) {
            int leftVal = root.left.val;
            edges.add(leftVal);
            Set<Integer> leftEdges = graph.computeIfAbsent(leftVal, k -> new HashSet<>());
            leftEdges.add(val);
        }

        if (root.right != null) {
            int rightVal = root.right.val;
            edges.add(rightVal);
            Set<Integer> rightEdges = graph.computeIfAbsent(rightVal, k -> new HashSet<>());
            rightEdges.add(val);
        }
    }
}
