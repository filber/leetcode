public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        // no element
        if (preStart > preEnd) {
            return null;
        }
        // one element
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart], null, null);
        }

        int rootValue = preorder[preStart];
        int jump = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootValue == inorder[i]) {
                jump = i - inStart;
                break;
            }
        }

        // build left tree
        TreeNode leftTree = buildTree(preorder, preStart + 1, preStart + jump,
                inorder, inStart, inStart + jump - 1);

        // build right tree
        TreeNode rightTree = buildTree(preorder, preStart + jump + 1, preEnd,
                inorder, inStart + jump + 1, inEnd);

        return new TreeNode(rootValue, leftTree, rightTree);
    }

    public static void main(String[] args) {
        TreeNode t1 = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode t2 = buildTree(new int[]{3}, new int[]{3});
        TreeNode t3 = buildTree(new int[]{3, 20, 15, 7}, new int[]{3, 15, 20, 7});
        TreeNode t4 = buildTree(new int[]{3, 9, 20, 7}, new int[]{20, 9, 7, 3});

    }
}
