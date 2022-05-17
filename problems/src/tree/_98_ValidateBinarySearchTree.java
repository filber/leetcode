package tree;

//https://leetcode.com/problems/validate-binary-search-tree/

public class _98_ValidateBinarySearchTree {

    Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }

    private boolean traverse(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!traverse(root.left)) {
            return false;
        }
        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;
        if (!traverse(root.right)) {
            return false;
        }
        return true;
    }
}
