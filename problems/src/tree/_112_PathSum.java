package tree;

//https://leetcode.com/problems/path-sum/

public class _112_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            int sum = targetSum - root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}
