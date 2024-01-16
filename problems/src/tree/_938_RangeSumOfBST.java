package tree;

//https://leetcode.com/problems/range-sum-of-bst/

public class _938_RangeSumOfBST {

    private int low;
    private int high;
    private int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        this.low = low;
        this.high = high;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        int val = root.val;
        if(val<low) {
            dfs(root.right);
        } else if (low<=val && val<=high) {
            sum += val;
            dfs(root.left);
            dfs(root.right);
        } else {
            dfs(root.left);
        }
    }
}
