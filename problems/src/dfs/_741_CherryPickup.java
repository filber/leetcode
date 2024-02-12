package dfs;

// https://leetcode.com/problems/cherry-pickup/

public class _741_CherryPickup {

    int n;
    int[][] grid;
    int[][][] memo;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        memo = new int[n][n][n];
        this.grid = grid;
        return Math.max(0, dp(memo, 0, 0, 0));
    }

    // the maximum score could earning starting from <x1,y1>, <x2,y2>
    private int dp(int[][][] memo, int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        if (x1 < 0 || x1 == n || y1 < 0 || y1 == n || x2 < 0 || x2 == n || y2 < 0 || y2 == n) {
            return Integer.MIN_VALUE; // out of boundary
        } else if (memo[x1][y1][x2] != 0) {
            return memo[x1][y1][x2];
        } else if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE;
        } else if (x1 == n - 1 && y1 == n - 1 && x2 == n - 1 && y2 == n - 1) {
            // END
            return grid[n - 1][n - 1]; // pick once
        }
        int score;
        if (x1 == x2 && y1 == y2) {
            score = grid[x1][y1]; // pick once
        } else {
            score = grid[x1][y1] + grid[x2][y2]; // pick separately
        }
        int maxNext = Math.max(
                Math.max(dp(memo, x1 + 1, y1, x2 + 1), dp(memo, x1, y1 + 1, x2 + 1)),
                Math.max(dp(memo, x1 + 1, y1, x2), dp(memo, x1, y1 + 1, x2))
        );
        memo[x1][y1][x2] = score + maxNext;
        return memo[x1][y1][x2];
    }
}
