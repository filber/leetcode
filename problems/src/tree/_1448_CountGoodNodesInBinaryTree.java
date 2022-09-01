package tree;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

public class _1448_CountGoodNodesInBinaryTree {

    int cnt = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return cnt;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            max = node.val;
            cnt++;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
