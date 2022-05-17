package tree;

//https://leetcode.com/problems/invert-binary-tree/

public class _226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
            return root;
        }
    }
}
