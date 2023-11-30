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

        TreeNode lNode = Objects.isNull(leftPair[0]) ? root : leftPair[0];
        TreeNode rNode = Objects.isNull(rightPair[1]) ? root : rightPair[1];
        return new TreeNode[]{lNode, rNode};
    }

}
