package tree;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/

public class _530_MinimumAbsoluteDifferenceInBST {

    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        midOrderTraverse(root);
        return minDiff;
    }

    private void midOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;

        midOrderTraverse(root.right);
    }

}
