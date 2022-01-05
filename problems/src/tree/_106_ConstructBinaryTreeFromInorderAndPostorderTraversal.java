package tree;

public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * Definition for a binary tree node.
     */
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd,
        int[] postorder, int postStart, int postEnd) {
        // no element
        if (inStart > inEnd) {
            return null;
        }
        // one element
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart], null, null);
        }

        int rootValue = postorder[postEnd];
        int jump = 0;
        // search jump size
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                jump = i - inStart;
                break;
            }
        }

        // build left tree
        TreeNode leftTree = buildTree(inorder, inStart, inStart + jump - 1,
                postorder, postStart, postStart + jump - 1);
        // build right tree
        TreeNode rightTree = buildTree(inorder, inStart + jump + 1, inEnd,
                postorder, postStart + jump, postEnd - 1);
        return new TreeNode(rootValue, leftTree, rightTree);
    }

    public static void main(String[] args) {
        TreeNode t1 = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        TreeNode t2 = buildTree(new int[]{1,2,3,4}, new int[]{3,2,4,1});
    }
}
