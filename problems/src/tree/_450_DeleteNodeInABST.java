package tree;

//https://leetcode.com/problems/delete-node-in-a-bst/

public class _450_DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode tree = delete(root, key);
        return tree;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // leaf node
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left.right == null) {
                TreeNode L = root.left;
                L.right = root.right;
                root.left = null;
                root.right = null;
                return L;
            } else {
                TreeNode pre = root.left;
                TreeNode L = root.left.right;
                while (L.right != null) {
                    pre = L;
                    L = L.right;
                }
                pre.right = L.left;
                L.left = root.left;
                L.right = root.right;
                return L;
            }
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            root.left = delete(root.left, key);
        }
        return root;
    }
}
