package dfs;

// https://leetcode.com/problems/max-area-of-island/

public class _695_MaxAreaOfIsland {

    int[][] grid;
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 0;
        } else if (grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        area += dfs(i - 1, j);
        area += dfs(i + 1, j);
        area += dfs(i, j - 1);
        area += dfs(i, j + 1);
        return area;
    }
}
