package tree;

//https://leetcode.com/problems/two-sum-bsts/

public class _1214_TwoSumBSTs {

    // Given two binary search trees, return True if and only if there is a node
    // in the first tree and a node in the second tree whose values sum up to a given integer target.

    public boolean findTarget(TreeNode L, TreeNode R, int k) {
        if (L == null || R == null) {
            return false;
        }
        int sum = L.val + R.val;
        if (sum == k) {
            return true;
        } else if (sum < k) {
            return findTarget(L.right, R, k) || findTarget(L, R.right, k);
        } else {
            return findTarget(L, R.left, k) || findTarget(L.left, R, k);
        }
    }
}
