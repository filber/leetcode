package dp;

// https://leetcode.com/problems/maximal-rectangle/
public class _85_MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n + 2];
        int maxArea = 0;
        int[] stack = new int[n + 2];
        for (int i = 0; i < m; i++) {
            int stackIdx = -1;
            for (int j = 0; j < n + 2; j++) {
                if (j == 0 || j == n + 1) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = matrix[i][j - 1] - '0';
                } else if (matrix[i][j - 1] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }

                while (stackIdx != -1 && dp[i][stack[stackIdx]] > dp[i][j]) {
                    int h = dp[i][stack[stackIdx--]]; // pop
                    int w = j - 1 - stack[stackIdx];
                    int area = h * w;
                    maxArea = Math.max(maxArea, area);
                }
                stack[++stackIdx] = j; // push
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // 6
        int m1 = maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}});

        // 0
        int m2 = maximalRectangle(new char[][]{
                {'0'}});

        // 1
        int m3 = maximalRectangle(new char[][]{
                {'1'}});

        // 1
        int m4 = maximalRectangle(new char[][]{
                {'0','1'},
                {'1','0'}});
    }
}
