package tree;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class _129_SumRootToLeafNumbers {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
            return;
        }

        sum *= 10;
        if (root.left != null) {
            dfs(root.left, sum);
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }
    }
}
