package tree;

//https://leetcode.com/problems/increasing-order-search-tree/

import java.util.Objects;

public class _897_IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] pair = dfs(root);
        return pair[0];
    }

    private TreeNode[] dfs(TreeNode root) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] rightPair = dfs(root.right);
        root.right = rightPair[0];

        TreeNode[] leftPair = dfs(root.left);

        if (root.left != null) {
            leftPair[1].right = root;
            root.left = null;
        }

        TreeNode lNode = Objects.requireNonNullElse(leftPair[0], root);
        TreeNode rNode = Objects.requireNonNullElse(rightPair[1], root);
        return new TreeNode[]{lNode, rNode};
    }

}
