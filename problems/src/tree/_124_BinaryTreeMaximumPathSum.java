package tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class _124_BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        int ans;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            max = Math.max(root.val, max);
            return root.val;
        } else if (root.left == null && root.right != null) {
            int rightVal = dfs(root.right);
            ans = Math.max(root.val, root.val + rightVal);
            max = Math.max(max, ans);
        } else if (root.left != null && root.right == null) {
            int leftVal = dfs(root.left);
            ans = Math.max(root.val, root.val + leftVal);
            max = Math.max(max, ans);
        } else {
            int leftVal = dfs(root.left) + root.val;
            int rightVal = dfs(root.right) + root.val;
            int sum = leftVal + rightVal - root.val;
            ans = Math.max(root.val, Math.max(leftVal, rightVal));
            max = Math.max(max, Math.max(sum, ans));
        }
        return ans;
    }
}
