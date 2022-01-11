package tree;

// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class _1022_SumOfRootToLeafBinaryNumbers {
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

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        backtracking(root, 0);
        return sum;
    }

    private void backtracking(TreeNode root, int val) {
        int res = val + root.val;
        if (root.left==null && root.right == null) {
            // leaf node
            sum += res;
            return;
        }

        if (root.left != null) {
            backtracking(root.left, res << 1);
        }
        if (root.right != null) {
            backtracking(root.right, res << 1);
        }
    }

    public static void main(String[] args) {
        int s1 = new _1022_SumOfRootToLeafBinaryNumbers().sumRootToLeaf(
                new TreeNode(1,
                        new TreeNode(0,
                                new TreeNode(0),
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(1))));
        int s2 = new _1022_SumOfRootToLeafBinaryNumbers().sumRootToLeaf(
                new TreeNode(0));
    }
}
