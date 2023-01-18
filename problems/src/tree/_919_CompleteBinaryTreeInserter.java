package tree;

//https://leetcode.com/problems/complete-binary-tree-inserter/description/

import java.util.ArrayDeque;
import java.util.Queue;

public class _919_CompleteBinaryTreeInserter {

    public static class CBTInserter {
        TreeNode root;
        Queue<TreeNode> queue = new ArrayDeque<>();

        public CBTInserter(TreeNode root) {
            if (root == null) {
                return;
            }
            this.root = root;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    queue.add(node);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
        }

        public int insert(int val) {
            while (!queue.isEmpty() && queue.peek().left != null && queue.peek().right != null) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                root = new TreeNode();
                root.val = val;
                queue.add(root);
                return root.val;
            } else {
                TreeNode parent = queue.peek();
                if (parent.left == null) {
                    parent.left = new TreeNode();
                    parent.left.val = val;
                    queue.add(parent.left);
                } else {
                    parent.right = new TreeNode();
                    parent.right.val = val;
                    queue.add(parent.right);
                }

                return parent.val;
            }
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
