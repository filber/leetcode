package tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class _235_LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        } else if (p.val == root.val || q.val == root.val) {
            return root;
        } else if (p.val < root.val && root.val < q.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            //root.val < p.val && root.val < q.val
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
