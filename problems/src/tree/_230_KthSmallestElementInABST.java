package tree;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class _230_KthSmallestElementInABST {

    int ans = 0;
    int idx;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        idx = 0;
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        idx++;
        if (idx == k) {
            ans = root.val;
            return;
        }
        traverse(root.right);
    }
}
