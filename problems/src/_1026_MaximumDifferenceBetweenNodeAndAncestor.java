//TOPICS:
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

    private void dfs(TreeNode node, int max, int min) {
        if (node==null) {
            int diff = max - min;
            maxDiff = diff > maxDiff ? diff : maxDiff;
            return;
        }
        max = node.val > max ? node.val : max;
        min = node.val < min ? node.val : min;
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }

    public static void main(String[] args) {
        int m1 = new _1026_MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(
                new TreeNode(0, new TreeNode(1), null));
        int m2 = new _1026_MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(0,
                                        new TreeNode(3),
                                        null))));
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
