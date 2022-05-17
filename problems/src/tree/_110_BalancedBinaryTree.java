package tree;

//https://leetcode.com/problems/balanced-binary-tree/

public class _110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            if (Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
