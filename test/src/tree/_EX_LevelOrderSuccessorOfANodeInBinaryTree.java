package tree;

//https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/

import java.util.ArrayDeque;
import java.util.Queue;

public class _EX_LevelOrderSuccessorOfANodeInBinaryTree {

    public TreeNode levelOrderSuccessor(TreeNode root, TreeNode key) {

        if (root == null) {
            return null;
        }

        boolean found = false;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (found) {
                    return node;
                }
                if (node == key) {
                    found = true;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }


        return null;
    }
}
