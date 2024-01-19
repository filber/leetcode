package dp;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class _1277_CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]: width of largest squares with <i,j> in the bottom-right corner
        // each element in matrix contributes dp[i][j] to the final answer
        int[][] dp = new int[m][n];

        // Init
        int result = 0;
        dp[0][0] = matrix[0][0];
        result += dp[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            result += dp[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j];
            result += dp[0][j];
        }

        // Iterate
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
                result += dp[i][j];
            }
        }

        return result;
    }
}
