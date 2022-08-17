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

    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int l = dfs(node.left), r = dfs(node.right);
        if (l == 0 || r == 0) {
            return 1; // visible
        } else if (l == 2 || r == 2) {
            ans++;
            return 0; // must place a camera
        } else {
            return 2; // not visible
        }
    }

}
