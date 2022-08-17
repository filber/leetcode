package tree;

//https://leetcode.com/problems/distribute-coins-in-binary-tree/

public class _979_DistributeCoinsInBinaryTree {

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val += dfs(node.left);
        node.val += dfs(node.right);
        moves += Math.abs(node.val - 1);
        return node.val - 1;
    }
}
