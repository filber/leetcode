
public class _889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
        return constructFromPrePost(preorder, postorder, 0, preorder.length - 1,
                0, postorder.length - 1);
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder,
                                                int preStart,int preEnd,
                                                int postStart, int postEnd) {
        // 0. Guard conditions
        if (preStart < 0 || preEnd >= preorder.length || preStart>preEnd ||
            postStart < 0 || postEnd >= postorder.length || postStart > postEnd) {
            return null; // no element
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]); // one element
        }

        // 1. Construct left-subtree
        // detect region size
        int leftRootValue = preorder[preStart + 1];
        int regionSize = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == leftRootValue) {
                regionSize = i - postStart + 1;
                break;
            }
        }
        TreeNode leftTree = constructFromPrePost(preorder, postorder,
                preStart + 1, preStart + regionSize,
                postStart, postStart + regionSize - 1);

        // 2. Construct right-subtree
        TreeNode rightTree = null;
        if (regionSize < (preEnd - preStart + 1)) {
            rightTree = constructFromPrePost(preorder, postorder,
                    preStart + regionSize + 1, preEnd,
                    postStart + regionSize, postEnd - 1);
        }

        // 3. Construct root node
        int rootValue = preorder[preStart];
        return new TreeNode(rootValue,leftTree,rightTree);
    }

    public static void main(String[] args) {
        TreeNode t1 = constructFromPrePost(
                new int[]{1},
                new int[]{1});

        TreeNode t2 = constructFromPrePost(
                new int[]{1,3,6,7},
                new int[]{6,7,3,1});

        TreeNode t3 = constructFromPrePost(
                new int[]{1,2,4,5,3,6,7},
                new int[]{4,5,2,6,7,3,1});
    }
}
