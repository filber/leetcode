package dp;

import java.util.Arrays;

public class _741_CherryPickup {
    private static int[][] direction = new int[][]{{0, 1}, {1, 0}};

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        int[][][][] dp = new int[n][n][n][n];
        int cnt = Math.max(0, dfs(grid,dp,0, 0, 0, 0));
        return cnt;
    }

    public static int dfs(int[][] grid,int[][][][] dp, int x1, int y1, int x2, int y2) {
        int n = grid.length;
        if (x1 == n - 1 && y1 == n - 1 && x2 == n - 1 && y2 == n - 1) {
            return grid[n-1][n-1];
        }
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) {
            return Integer.MIN_VALUE;
        }
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            dp[x1][y1][x2][y2] = Integer.MIN_VALUE;
            dp[x2][y2][x1][y1] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        if (dp[x1][y1][x2][y2] != 0) {
            return dp[x1][y1][x2][y2];
        }

        int gridValue = x1 == x2 && y1 == y2
                ? grid[x1][y1]
                : grid[x1][y1] + grid[x2][y2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < direction.length; i++) {
            int[] d1 = direction[i];
            for (int j = 0; j < direction.length; j++) {
                int[] d2 = direction[j];
                int nextValue = dfs(grid,dp,
                        x1 + d1[0], y1 + d1[1],
                        x2 + d2[0], y2 + d2[1]);
                max = Math.max(max, gridValue + nextValue);
            }
        }
        dp[x1][y1][x2][y2] = max;
        dp[x2][y2][x1][y1] = max;
        return max;
    }

    public static void main(String[] args) {
        // 0
        int c1 = cherryPickup(new int[][]{
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1}});
        // 5
        int c2 = cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}});
        // 15
        int c3 = cherryPickup(new int[][]{
                {1,1,1,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,1,1,1}
        });
        // 23
        int c4 = cherryPickup(new int[][]{
                {1, -1, 1, 1, 1, 1, 1, 1, -1, 1},
                {1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
                {-1, 1, 1, -1, 1, 1, 1, 1, 1, 1},
                {1, 1, -1, 1, -1, 1, 1, 1, 1, 1},
                {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {-1, -1, 1, 1, 1, -1, 1, 1, -1, 1},
                {1, 1, 1, 1, 1, 1, 1, -1, 1, 1},
                {1, 1, 1, 1, -1, 1, -1, -1, 1, 1},
                {1, -1, 1, -1, -1, 1, 1, -1, 1, -1},
                {-1, 1, -1, 1, -1, 1, 1, 1, 1, 1}});
    }
}
