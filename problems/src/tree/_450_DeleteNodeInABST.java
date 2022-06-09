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
        } else if (root.left == null && root.right == null) {
            // leaf node
            if (root.val == key) {
                return null;
            }
            return root;
        } else if (root.left == null) {
            if (root.val == key) {
                return root.right;
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        } else if (root.right == null) {
            if (root.val == key) {
                return root.left;
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }

        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode pre = null;
            while (left.right != null) {
                pre = left;
                left = left.right;
            }
            if (pre != null) {
                pre.right = null;
                left.left = root.left;
            }
            left.right = root.right;

            root.left = null;
            root.right = null;
            return left;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
