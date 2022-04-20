package tree;

//https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

public class _173_BinarySearchTreeIterator {

    public static class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            return val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
