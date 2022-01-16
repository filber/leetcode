package tree;

// https://leetcode.com/problems/maximum-binary-tree-ii/
public class _998_MaximumBinaryTreeII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // 1. Construct new root
        if (root == null) {
            return new TreeNode(val);
        }
        // 2. Insert root to be the left subtree
        if (root.val < val) {
            return new TreeNode(val, root, null);
        }
        // 3. Insert to the right subtree of root
        if (root.val > val) {
            TreeNode rightTree = insertIntoMaxTree(root.right,val);
            root.right = rightTree;
            return root;
        }

        throw new IllegalArgumentException(
                String.format("value %d already exits in the tree", val));
    }

    public static void main(String[] args) {
        TreeNode t1 = insertIntoMaxTree(null,1);

        TreeNode t2 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(3,
                        new TreeNode(2),
                        null));
        t2 = insertIntoMaxTree(t2, 5);

        TreeNode t3 = new TreeNode(5,
                new TreeNode(2,
                        null,new TreeNode(1)),
                new TreeNode(4));
        t3 = insertIntoMaxTree(t3, 3);

        TreeNode t4 = new TreeNode(5,
                new TreeNode(2,
                        null,new TreeNode(1)),
                new TreeNode(3));
        t4 = insertIntoMaxTree(t4, 4);
    }
}
