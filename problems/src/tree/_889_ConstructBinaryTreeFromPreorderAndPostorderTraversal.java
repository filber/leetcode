package tree;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

public class _889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

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

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return construct(preorder, 0, n - 1,
                postorder, 0, n - 1);
    }

    public static TreeNode construct(int[] preorder, int preStart, int preEnd,
                                     int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        } else if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int leftRoot = preorder[preStart + 1];
        int postOrderLeftRoot = 0;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == leftRoot) {
                postOrderLeftRoot = i;
                break;
            }
        }
        int jump = postOrderLeftRoot - postStart;

        TreeNode leftSubTree = construct(
                preorder, preStart + 1, preStart + 1 + jump,
                postorder, postStart, postOrderLeftRoot);
        TreeNode rightSubTree = construct(
                preorder, preStart + 2 + jump, preEnd,
                postorder, postOrderLeftRoot + 1, postEnd - 1);

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal, leftSubTree, rightSubTree);
        return root;
    }


    public static void main(String[] args) {
        TreeNode t1 = constructFromPrePost(
                new int[]{1},
                new int[]{1});

        TreeNode t2 = constructFromPrePost(
                new int[]{1, 3, 6, 7},
                new int[]{6, 7, 3, 1});

        TreeNode t3 = constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1});
    }
}
