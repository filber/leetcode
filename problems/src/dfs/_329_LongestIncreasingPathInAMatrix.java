package dfs;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class _329_LongestIncreasingPathInAMatrix {

    int[][] dp;
    int[][] matrix;
    int m;
    int n;
    int maxLen = 0;

    private static final int[][] DIR = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        this.matrix = matrix;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    dfs(-1, i, j);
                }
            }
        }
        return maxLen;
    }

    private int dfs(int prev, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 0;
        } else if (prev >= matrix[i][j]) {
            return 0;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }

        for (int[] dir : DIR) {
            int nextI = dir[0] + i;
            int nextJ = dir[1] + j;
            dp[i][j] = Math.max(dp[i][j], dfs(matrix[i][j], nextI, nextJ) + 1);
        }
        maxLen = Math.max(maxLen, dp[i][j]);
        return dp[i][j];
    }

}
