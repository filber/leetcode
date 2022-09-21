package tree;

//https://leetcode.com/problems/house-robber-iii/

public class _337_HouseRobberIII {

    public int rob(TreeNode root) {
        int[] amt = dfs(root);
        return Math.max(amt[0], amt[1]);
    }

    /**
     * rst[0]: without root
     * rst[1]: with root
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int withRoot = root.val + left[0] + right[0];
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{withoutRoot, withRoot};
    }
}