package tree;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

public class _103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean even = false;
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (even) {
                Collections.reverse(levelNodes);
            }
            list.add(levelNodes);
            even = !even;
        }

        return list;
    }
}
