package dfs;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
//[Depth-First Search]
public class _1026_MaximumDifferenceBetweenNodeAndAncestor {

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

    private int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    public void dfs(TreeNode root,int max, int min) {
        if (root == null) {
            maxDiff = Math.max(maxDiff, max - min);
            return;
        }
        max = Math.max(root.val,max);
        min = Math.min(root.val,min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }


    public static void main(String[] args) {
        // 1
        int m1 = new _1026_MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(
                new TreeNode(0, new TreeNode(1), null));
        // 3
        int m2 = new _1026_MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(0,
                                        new TreeNode(3),
                                        null))));
        // 7
        int m3 = new _1026_MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(
                new TreeNode(8,
                        new TreeNode(3,
                            new TreeNode(1),
                            new TreeNode(6,
                                    new TreeNode(4),
                                    new TreeNode(7))),
                        new TreeNode(10,
                            null,
                            new TreeNode(14,
                                    new TreeNode(13), null))));
    }
}
