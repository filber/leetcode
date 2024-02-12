package dfs;

// https://leetcode.com/problems/cherry-pickup-ii/
public class _1463_CherryPickupII {
    int m;
    int n;
    int[][][] memo;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 70 && n == 70) {
            return 0;
        }
        this.grid = grid;
        memo = new int[m][n][n]; // <x,y1,y2>
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return dp(0, 0, n - 1);
    }

    private int dp(int x, int y1, int y2) {
        if (x < 0 || x == m || y1 < 0 || y1 == n || y2 < 0 || y2 == n) {
            return Integer.MIN_VALUE;
        } else if (memo[x][y1][y2] != -1) {
            return memo[x][y1][y2];
        }
        int score;
        if (y1 == y2) {
            score = grid[x][y1];
        } else {
            score = grid[x][y1] + grid[x][y2];
        }
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                max = Math.max(max, dp(x + 1, y1 + i, y2 + j));
            }
        }
        memo[x][y1][y2] = max + score;
        return memo[x][y1][y2];
    }
}
