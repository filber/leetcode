package tree;

//https://leetcode.com/problems/merge-two-binary-trees/

public class _617_MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode L, TreeNode R) {
        if (L == null) {
            return R;
        } else if (R == null) {
            return L;
        }
        L.val += R.val;
        L.left = mergeTrees(L.left, R.left);
        L.right = mergeTrees(L.right, R.right);
        return L;
    }
}
