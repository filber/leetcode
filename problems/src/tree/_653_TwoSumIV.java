package tree;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class _653_TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }

    private boolean helper(TreeNode root, TreeNode cur, int k) {
        if (cur == null) {
            return false;
        }

        return dfs(root, cur, k - cur.val)
                || helper(root, cur.left, k)
                || helper(root, cur.right, k);
    }
    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (root == null) {
            return false;
        }
        if (root.val < k) {
            return dfs(root.right, cur, k);
        }
        if (root.val > k) {
            return dfs(root.left, cur, k);
        }
        return root != cur;
    }
}
