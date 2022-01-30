package dp;

// https://leetcode.com/problems/maximal-square/

public class _221_MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='0') {
                    dp[i][j] = 0;
                } else {
                    int top = i == 0 ? 0 : dp[i - 1][j];
                    int left = j == 0 ? 0 : dp[i][j - 1];
                    int topLeft = i != 0 && j != 0 ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(top, Math.min(left, topLeft)) + 1;
                }
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // 4
        int m1 = maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}});

        // 1
        int m2 = maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}});
    }
}
