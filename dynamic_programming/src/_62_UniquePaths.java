// TOPICS:
// [Dynamic Programming], [Matrix]

public class _62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[i][j] represent the destination trying to arrive
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0) {
                    // First row
                    dp[i][j] = 1;
                } else if (j==0) {
                    // First column
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePathsMem(int m, int n) {
        int[][] mem = new int[m][n];
        return uniquePaths(m - 1, n - 1, 0, 0, mem);
    }

    public static int uniquePaths(int targetX, int targetY, int x, int y,int[][] mem) {
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        if (targetX == x || targetY == y) {
            return 1;
        }
        // move downside
        int downCnt = uniquePaths(targetX, targetY, x + 1, y, mem);
        // move right
        int rightCnt = uniquePaths(targetX, targetY, x, y + 1, mem);
        mem[x][y] = downCnt + rightCnt;
        return mem[x][y];
    }

    public static void main(String[] args) {
        int t1 = uniquePaths(1, 1);
        int t2 = uniquePaths(1, 2);
        int t3 = uniquePaths(2, 1);
        int t4 = uniquePaths(2, 2);
        int t5 = uniquePaths(3, 2);
        int t6 = uniquePaths(3, 7);
    }
}
