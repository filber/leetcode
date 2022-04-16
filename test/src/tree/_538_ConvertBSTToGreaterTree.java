package tree;

//https://leetcode.com/problems/convert-bst-to-greater-tree/

public class _538_ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public TreeNode dfs(TreeNode root, int sum) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            root.val += sum;
            return root;
        } else if (root.left == null) {
            TreeNode maxRight = dfs(root.right, sum);
            root.val += maxRight.val;
            return root;
        } else if (root.right == null) {
            root.val += sum;
            return dfs(root.left, root.val);
        } else {
            TreeNode maxRight = dfs(root.right, sum);
            root.val += maxRight.val;
            TreeNode maxLeft = dfs(root.left, root.val);
            return maxLeft;
        }
    }
}
