package tree;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class _129_SumRootToLeafNumbers {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum *= 10;
        sum += root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }
}
