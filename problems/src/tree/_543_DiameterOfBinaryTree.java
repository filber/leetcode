package tree;

//https://leetcode.com/problems/diameter-of-binary-tree/

public class _543_DiameterOfBinaryTree {


    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode root) {
        int len;
        if (root == null || root.left == null && root.right == null) {
            len = 0;
        } else if (root.left == null) {
            len = longestPath(root.right) + 1;
            diameter = Math.max(diameter, len);
        } else if (root.right == null) {
            len = longestPath(root.left) + 1;
            diameter = Math.max(diameter, len);
        } else {
            int leftPath = longestPath(root.left);
            int rightPath = longestPath(root.right);
            len = Math.max(leftPath, rightPath) + 1;
            diameter = Math.max(diameter, leftPath + rightPath + 2);
        }

        return len;
    }
}
