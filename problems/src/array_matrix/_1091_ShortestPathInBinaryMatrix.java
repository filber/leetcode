package array_matrix;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _1091_ShortestPathInBinaryMatrix {

    private static final int[][] DIR = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int path = node[2];
            if (path >= dp[i][j]) {
                continue;
            }
            dp[i][j] = path;
            int nextPath = path + 1;
            for (int[] d : DIR) {
                int nextI = i + d[0];
                int nextJ = j + d[1];
                if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n || grid[nextI][nextJ] == 1 || nextPath >= dp[nextI][nextJ]) {
                    continue;
                }
                queue.add(new int[]{nextI, nextJ, nextPath});
            }
        }

        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1][n - 1];
    }
}
