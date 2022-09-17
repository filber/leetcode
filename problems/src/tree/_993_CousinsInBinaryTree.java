package tree;

//https://leetcode.com/problems/cousins-in-binary-tree/

public class _993_CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        int[] left = dfs(root, -1, 0, x);
        int[] right = dfs(root, -1, 0, y);
        return left[0] != right[0] && left[1] == right[1];
    }

    private int[] dfs(TreeNode node, int parent, int depth, int value) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            return new int[]{parent, depth + 1};
        }
        int[] left = dfs(node.left, node.val, depth + 1, value);
        if (left != null) {
            return left;
        }
        return dfs(node.right, node.val, depth + 1, value);
    }

}
