package tree;

//https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/

public class _1430_CheckIfAStringIsAValidSequence {

    int[] sequence;

    public boolean isValidSequence(TreeNode root, int[] sequence) {
        this.sequence = sequence;
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int i) {
        if (root == null) {
            return false;
        } else if (i == sequence.length) {
            return false;
        } else if (root.left == null && root.right == null && i == sequence.length - 1) {
            return root.val == sequence[i];
        } else if (root.val != sequence[i]) {
            return false;
        } else {
            return dfs(root.left, i + 1) || dfs(root.right, i + 1);
        }
    }
}
