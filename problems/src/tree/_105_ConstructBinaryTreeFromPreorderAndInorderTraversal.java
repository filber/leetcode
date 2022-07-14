package tree;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        TreeNode root = buildTree(0, n - 1, 0, n - 1);
        return root;
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        } else if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int rootIdx = inStart;

        while (inorder[rootIdx] != rootVal) {
            rootIdx++;
        }
        int leftLen = rootIdx - inStart;
        TreeNode leftNode = buildTree(preStart + 1, preStart + leftLen, inStart, inStart + leftLen - 1);
        TreeNode rightNode = buildTree(preStart + leftLen + 1, preEnd, rootIdx + 1, inEnd);
        return new TreeNode(rootVal, leftNode, rightNode);
    }
}
