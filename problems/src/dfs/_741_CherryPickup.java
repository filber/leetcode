package dfs;

// https://leetcode.com/problems/cherry-pickup/

public class _741_CherryPickup {
    private static int[][] direction = new int[][]{{0, 1}, {1, 0}};

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] mem = new int[n][n][n];

        int gridValue = dfs(grid, mem, 0, 0, 0);
        return Math.max(0, gridValue);
    }

    private static int dfs(int[][] grid, int[][][] mem, int x1, int y1, int x2) {
        int n = grid.length;
        // total steps : x1 + y1
        // y2 = ts - x2
        int y2 = x1 + y1 - x2;
        if (x1 == n - 1 && y1 == n - 1 && x2 == n - 1 && y2 == n - 1) {
            return grid[n - 1][n - 1];
        } else if (x1 < 0 || x1 >= n || y1 >= n || x2 < 0 || x2 >= n || y2 >= n) {
            return Integer.MIN_VALUE;
        } else if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE;
        } else if (mem[x1][y1][x2] != 0) {
            return mem[x1][y1][x2];
        }

        // 1. Calculate grid Value
        int gridVal = (x1 == x2 && y1 == y2) ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2];

        // 2. Cartesian product for next moves
        int maxValue = Integer.MIN_VALUE;
        for (int[] firstMove : direction) {
            for (int[] secondMove : direction) {
                int nextValue = dfs(grid, mem,
                        x1 + firstMove[0],
                        y1 + firstMove[1],
                        x2 + secondMove[0]);
                maxValue = Math.max(maxValue, nextValue + gridVal);
            }
        }

        mem[x1][y1][x2] = maxValue;
        return maxValue;
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
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
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
