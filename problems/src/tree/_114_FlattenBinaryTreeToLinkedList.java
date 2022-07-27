package tree;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class _114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        TreeNode left = root.left;
        if (left == null) {
            flatten(root.right);
        } else {
            TreeNode pre = left;
            while (pre.right != null) {
                pre = pre.right;
            }
            flatten(root.right);
            pre.right = root.right;
            root.right = left;
            root.left = null;
        }
    }
}
