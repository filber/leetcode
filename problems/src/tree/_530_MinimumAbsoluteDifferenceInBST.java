package tree;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/

public class _530_MinimumAbsoluteDifferenceInBST {

    int minDiff = Integer.MAX_VALUE;
    Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minDiff;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        traverse(root.right);
    }
}
