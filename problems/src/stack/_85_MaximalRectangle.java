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
                if (matrix[i][j] == '0') {
                    dp[i][j + 1] = 0;
                } else {
                    dp[i][j + 1] = dp[i - 1][j + 1] + 1;
                }
            }
        }

        int[] stack = new int[n + 2];
        int top;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            top = 0;
            stack[0] = 0;
            for (int j = 1; j < n + 2; j++) {
                int h = dp[i][j];
                while (dp[i][stack[top]] > h) {
                    int height = dp[i][stack[top--]];
                    int width = j - 1 - stack[top];
                    maxArea = Math.max(maxArea, height * width);
                }
                stack[++top] = j;
            }
        }

        return maxArea;
    }
}
