package dp;

// https://leetcode.com/problems/maximal-square/

public class _221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] - '0';
        maxArea = dp[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxArea = Math.max(maxArea, dp[i][0]);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxArea = Math.max(maxArea, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }
        return maxArea;
    }
}
