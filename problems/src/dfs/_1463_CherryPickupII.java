package dfs;

// https://leetcode.com/problems/cherry-pickup-ii/
public class _1463_CherryPickupII {
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        int res = dfs(grid, dp, 0, 0,n - 1);

        return res;
    }

    public static int dfs(int[][] grid, int[][][] dp, int x, int y1,int y2) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Guard condition
        if (x >= m || x < 0 ||
            y1 >= n || y1 < 0 ||
            y2 >= n || y2 < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[x][y1][y2] > 0) {
            return dp[x][y1][y2];
        }
        if (x == m - 1) {
            // reach bottom row
            if (y1==y2) {
                return grid[x][y1];
            } else {
                return grid[x][y1] + grid[x][y2];
            }
        }

        // 2. GridValue
        int gridValue;
        if (y1 == y2) {
            gridValue = grid[x][y1];
        } else {
            gridValue = grid[x][y1] + grid[x][y2];
        }

        // 3. Recursion
        int maxVal = Integer.MIN_VALUE;
        // loop 9 times
        for (int l = -1; l <= 1; l++) {
            for (int r = -1; r <= 1; r++) {
                int nextVal = dfs(grid, dp, x+1, y1+l, y2+r);
                maxVal = Math.max(maxVal, nextVal);
            }
        }

        // 4. Set dp
        dp[x][y1][y2] = maxVal + gridValue;
        dp[x][y2][y1] = maxVal + gridValue;
        return maxVal + gridValue;
    }

    public static void main(String[] args) {
        // 24
        int m1 = cherryPickup(
                new int[][]{
                        {3, 1, 1},
                        {2, 5, 1},
                        {1, 5, 5},
                        {2, 1, 1}});

        // 28
        int m2 = cherryPickup(
                new int[][]{
                        {1,0,0,0,0,0,1},
                        {2,0,0,0,0,3,0},
                        {2,0,9,0,0,0,0},
                        {0,3,0,5,4,0,0},
                        {1,0,2,3,0,0,6}
                });
    }
}
