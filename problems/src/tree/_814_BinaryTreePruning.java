package tree;

//https://leetcode.com/problems/binary-tree-pruning/

public class _814_BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return root;
            } else {
                return null;
            }
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        root.left = left;
        root.right = right;
        if (left == null && right == null) {
            if (root.val == 1) {
                return root;
            } else {
                return null;
            }
        }
        return root;
    }
}
