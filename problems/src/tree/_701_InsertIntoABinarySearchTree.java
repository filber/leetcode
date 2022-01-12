package tree;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/

public class _701_InsertIntoABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode p = root;
        TreeNode cur = root;
        while (cur!= null) {
            p = cur;
            if (cur.val<val) {
                // insert into right
                cur = cur.right;
            } else {
                // insert into left
                cur = cur.left;
            }
        }
        if (p.val < val) {
            p.right = new TreeNode(val);
        } else {
            p.left = new TreeNode(val);
        }

        return root;
    }

    public static TreeNode insertIntoBSTDFS(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            // insert into the right
            root.right = insertIntoBST(root.right, val);
        } else {
            // insert into the left
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = insertIntoBST(
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(7)),
                5);

        TreeNode r2 = insertIntoBST(null,1);
    }
}
