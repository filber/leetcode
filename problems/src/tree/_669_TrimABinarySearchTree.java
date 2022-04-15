package tree;

//https://leetcode.com/problems/trim-a-binary-search-tree/

public class _669_TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        } else if (high < root.val) {
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else {
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
            return root;
        }
    }
}
