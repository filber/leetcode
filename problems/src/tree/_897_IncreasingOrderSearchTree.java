package tree;

//https://leetcode.com/problems/increasing-order-search-tree/

public class _897_IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            root.right = increasingBST(root.right);
            return root;
        } else if (root.right == null) {
            TreeNode left = increasingBST(root.left);
            TreeNode mostRight = getMostRight(left);
            mostRight.right = root;
            root.left = null;
            return left;
        } else {
            TreeNode left = increasingBST(root.left);
            TreeNode mostRight = getMostRight(left);
            mostRight.right = root;
            root.left = null;
            root.right = increasingBST(root.right);
            return left;
        }
    }

    private TreeNode getMostRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
