package tree;

//https://leetcode.com/problems/two-sum-bsts/

public class _1214_TwoSumBSTs {

    // Given two binary search trees, return True if and only if there is a node
    // in the first tree and a node in the second tree whose values sum up to a given integer target.

    private int k;

    public boolean findTarget(TreeNode L, TreeNode R, int k) {
        this.k = k;
        return dfs(L, R);
    }

    private boolean dfs(TreeNode L, TreeNode R) {
        if (L == null || R == null) {
            return false;
        } else if (L.val + R.val == k) {
            return true;
        } else if (L.val + R.val > k) {
            if (dfs(L, R.left) || dfs(L.left, R)) {
                return true;
            }
        } else {
            if (dfs(L, R.right) || dfs(L.right, R)) {
                return true;
            }
        }
        return false;
    }
}
