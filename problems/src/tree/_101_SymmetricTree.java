package tree;

//https://leetcode.com/problems/symmetric-tree/

public class _101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        } else if (L == null || R == null) {
            return false;
        } else if (L.val != R.val) {
            return false;
        } else {
            return dfs(L.left, R.right) && dfs(L.right, R.left);
        }
    }
}
