package tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/

// A binary tree's maximum depth is the number of nodes along
// the longest path from the root node down to the farthest leaf node.
public class _104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxSub = Math.max(maxDepth(root.left), maxDepth(root.right));
        return maxSub + 1;
    }
}
