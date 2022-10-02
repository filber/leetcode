package tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class _236_LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if (L != null && R != null) {
            return root;
        } else if (L != null) {
            return L;
        } else {
            return R;
        }
    }
}
