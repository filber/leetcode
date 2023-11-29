package tree;


// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
public class _2265_CountNodesEqualToAverageOfSubtree {

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] res = new int[]{left[0] + right[0] + 1, left[1] + right[1] + node.val};
        if (node.val == res[1] / res[0]) {
            count++;
        }
        return res;
    }
}
