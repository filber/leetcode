package dp;

//https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_PacificAtlanticWaterFlow {

    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        this.heights = heights;
        boolean[][] pDP = new boolean[m][n];
        boolean[][] aDP = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(pDP, i, 0);
            dfs(aDP, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(pDP, 0, j);
            dfs(aDP, m - 1, j);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pDP[i][j] && aDP[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }
        return list;
    }

    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(boolean[][] dp, int i, int j) {
        if (dp[i][j]) {
            return;
        }
        dp[i][j] = true;
        int h = heights[i][j];

        for (int k = 0; k < dir.length; k++) {
            int nextI = i + dir[k][0];
            int nextJ = j + dir[k][1];
            if (nextI < 0 || nextI == dp.length || nextJ < 0 || nextJ == dp[0].length) {
                continue;
            } else if (heights[nextI][nextJ] < h) {
                continue;
            }
            dfs(dp, nextI, nextJ);
        }
    }
}
