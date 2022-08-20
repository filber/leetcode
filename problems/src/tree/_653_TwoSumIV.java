package tree;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class _653_TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }

    // if exits p in P, q in Q, p.val+q.val=k, p!=q
    private boolean helper(TreeNode P, TreeNode Q, int k) {
        if (Q == null) {
            return false;
        }
        if (dfs(P, Q, k - Q.val)) {
            return true;
        } else if (helper(P, Q.left, k) || helper(P, Q.right, k)) {
            return true;
        } else {
            return false;
        }
    }

    // if exits node p in P, p.val=t and p!=q
    private boolean dfs(TreeNode P, TreeNode q, int t) {
        if (P == null) {
            return false;
        }
        if (P.val > t) {
            return dfs(P.right, q, t);
        } else if (P.val < t) {
            return dfs(P.left, q, t);
        } else {
            return P != q;
        }
    }
}
