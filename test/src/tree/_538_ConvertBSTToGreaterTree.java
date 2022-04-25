package tree;

//https://leetcode.com/problems/convert-bst-to-greater-tree/

public class _538_ConvertBSTToGreaterTree {

    int val = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        root.val += val;
        val = root.val;
        dfs(root.left);
    }

}
