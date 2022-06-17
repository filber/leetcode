package tree;

//https://leetcode.com/problems/binary-tree-cameras/

public class _968_BinaryTreeCameras {

    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 2) {
            ans++;
        }
        return ans;
    }

    // 0: placed camera at root
    // 1: root is visible
    // 2: root is not visible
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            return 1;
        } else if (left == 2 || right == 2) {
            ans++;
            return 0;
        } else {
            return 2;
        }
    }
}
