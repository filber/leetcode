package tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class _124_BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        largestPath(root);
        return maxSum;
    }

    private int largestPath(TreeNode root) {
        int sum;
        if (root.left == null && root.right == null) {
            sum = root.val;
        } else if (root.left == null) {
            sum = Math.max(root.val, root.val + largestPath(root.right));
        } else if (root.right == null) {
            sum = Math.max(root.val, root.val + largestPath(root.left));
        } else {
            int leftSum = largestPath(root.left) + root.val;
            int rightSum = largestPath(root.right) + root.val;
            sum = Math.max(root.val, Math.max(leftSum, rightSum));
            int bothSum = leftSum + rightSum - root.val;
            maxSum = Math.max(maxSum, bothSum);
        }

        maxSum = Math.max(maxSum, sum);
        return sum;
    }
}
