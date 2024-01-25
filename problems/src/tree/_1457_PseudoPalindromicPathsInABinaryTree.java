package tree;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
public class _1457_PseudoPalindromicPathsInABinaryTree {

    int paths = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] cnt = new int[10];
        dfs(root, cnt);
        return paths;
    }

    private void dfs(TreeNode root, int[] cnt) {
        int val = root.val;
        cnt[val]++;
        if (root.left == null && root.right == null) {
            // leaf node
            if (isPalindromic(cnt)) {
                paths++;
            }
        }
        if (root.left != null) {
            dfs(root.left, cnt);
        }
        if (root.right != null) {
            dfs(root.right, cnt);
        }
        cnt[val]--;
    }

    private boolean isPalindromic(int[] cnt) {
        int oddCnt = 0;
        for (int count : cnt) {
            if (count % 2 != 0) {
                oddCnt++;
            }
        }
        return oddCnt <= 1;
    }
}
