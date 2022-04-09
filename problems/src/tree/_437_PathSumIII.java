package tree;

//https://leetcode.com/problems/path-sum-iii/

public class _437_PathSumIII {

    int paths = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum); // Use root
        pathSum(root.left, targetSum); // skip root
        pathSum(root.right, targetSum); // skip root
        return paths;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        // use root
        sum -= root.val;
        if (sum == 0) {
            paths++;
        }
        // already use root, must use left
        dfs(root.left, sum);
        // already use root, must use right
        dfs(root.right, sum);
    }
}
