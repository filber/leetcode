package tree;

//https://leetcode.com/problems/recover-binary-search-tree/

public class _99_RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode last = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (pre != null) {
            if (pre.val > root.val) {
                if (first == null) {
                    first = pre;
                }
                last = root;
            }
        }
        pre = root;

        dfs(root.right);
    }

}
