package dfs;

// https://leetcode.com/problems/cherry-pickup-ii/
public class _1463_CherryPickupII {
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] mem = new int[m][n][n];
        int res = dfs(grid, mem, 0, 0, n - 1);
        return res;
    }

    private static int dfs(int[][] grid, int[][][] mem, int x, int y1, int y2) {
        int m = grid.length;
        int n = grid[0].length;

        // 0. Guard condition
        if (y1 < 0 || y1 >= n || y2 < 0 || y2 >= n) {
            // outside
            return Integer.MIN_VALUE;
        } else if (mem[x][y1][y2] != 0) {
            // memorized
            return mem[x][y1][y2];
        } else if (x == m - 1) {
            // termination
            int gridVal = y1 == y2 ? grid[x][y1] : grid[x][y1] + grid[x][y2];
            return gridVal;
        }

        int gridVal = y1 == y2 ? grid[x][y1] : grid[x][y1] + grid[x][y2];
        int max = Integer.MIN_VALUE;
        for (int l = -1; l <= 1; l++) {
            for (int r = -1; r <= 1; r++) {
                max = Math.max(max, gridVal + dfs(grid, mem, x + 1, y1 + l, y2 + r));
            }
        }

        mem[x][y1][y2] = max;
        return max;
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
                        {1, 0, 0, 0, 0, 0, 1},
                        {2, 0, 0, 0, 0, 3, 0},
                        {2, 0, 9, 0, 0, 0, 0},
                        {0, 3, 0, 5, 4, 0, 0},
                        {1, 0, 2, 3, 0, 0, 6}
                });
    }
}
