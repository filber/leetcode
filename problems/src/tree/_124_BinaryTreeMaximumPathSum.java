package tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class _124_BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        int sum;
        int bothSum = Integer.MIN_VALUE;
        if (node.left == null && node.right == null) {
            sum = node.val;
        } else if (node.left == null) {
            int rightSum = dfs(node.right) + node.val;
            sum = Math.max(node.val, rightSum);
        } else if (node.right == null) {
            int leftSum = dfs(node.left) + node.val;
            sum = Math.max(node.val, leftSum);
        } else {
            int rightSum = dfs(node.right) + node.val;
            int leftSum = dfs(node.left) + node.val;
            sum = Math.max(node.val, Math.max(leftSum, rightSum));
            bothSum = leftSum + rightSum - node.val;
        }
        maxSum = Math.max(maxSum, Math.max(sum, bothSum));
        return sum;
    }
}
