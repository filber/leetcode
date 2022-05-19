package bfs;

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

        this.matrix = matrix;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    dfs(Integer.MIN_VALUE, i, j);
                }
            }
        }

        return maxLen;
    }

    private int dfs(int preVal, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 0;
        } else if (preVal >= matrix[i][j]) {
            return 0;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int curLen = 0;
        int v = matrix[i][j];
        for (int[] dir : DIR) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            int nextLen = dfs(v, nextI, nextJ);
            curLen = Math.max(curLen, nextLen);
        }

        dp[i][j] = curLen + 1;
        maxLen = Math.max(maxLen, dp[i][j]);
        return dp[i][j];
    }
}
