package stack;

// https://leetcode.com/problems/maximal-rectangle/
public class _85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n + 2];
        for (int j = 0; j < n; j++) {
            dp[0][j + 1] = matrix[0][j] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j + 1] = dp[i - 1][j + 1] + 1;
                }
            }
        }

        int maxArea = 0;
        int[] stack = new int[n + 2];
        int peek = 0;
        for (int i = 0; i < m; i++) {
            peek = 0; // reset stack
            for (int j = 1; j <= n + 1; j++) {
                while (peek > 0 && dp[i][stack[peek]] >= dp[i][j]) {
                    int height = dp[i][stack[peek]];
                    peek--;
                    int width = j - stack[peek] - 1;
                    maxArea = Math.max(maxArea, width * height);
                }
                stack[++peek] = j;
            }
        }

        return maxArea;
    }
}
