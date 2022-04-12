package tree;

//https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/

public class _1430_CheckIfAStringIsAValidSequence {

    int[] sequence;
    int n;

    public boolean isValidSequence(TreeNode root, int[] sequence) {
        this.sequence = sequence;
        n = sequence.length;
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int i) {
        if (root == null && i == n) {
            return true;
        } else if (root == null || i == n) {
            return false;
        } else if (root.val != sequence[i]) {
            return false;
        } else if (root.left == null) {
            return dfs(root.right, i + 1);
        } else if (root.right == null) {
            return dfs(root.left, i + 1);
        } else {
            return dfs(root.left, i + 1) || dfs(root.right, i + 1);
        }
    }
}
