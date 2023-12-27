package dp;

// https://leetcode.com/problems/unique-paths-ii/

public class _63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 0 && dp[i - 1][0] != 0) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 0 && dp[0][j - 1] != 0) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
