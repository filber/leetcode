package tree;

//https://leetcode.com/problems/diameter-of-binary-tree/

public class _543_DiameterOfBinaryTree {


    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }

        int left = root.left == null ? 0 : (longestPath(root.left) + 1);
        int right = root.right == null ? 0 : (longestPath(root.right) + 1);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right);
    }
}
