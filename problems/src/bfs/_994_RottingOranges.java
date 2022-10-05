package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class _994_RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        // Traverse grid for rotten orange, add them to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // Use BFS to calculate time
        int time;
        if (queue.isEmpty()) {
            time = 0;
        } else {
            time = -1;
        }
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                for (int[] d : dir) {
                    int nextI = i + d[0];
                    int nextJ = j + d[1];
                    if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n || grid[nextI][nextJ] != 1) {
                        continue;
                    }
                    grid[nextI][nextJ] = 2;
                    queue.add(new int[]{nextI, nextJ});
                }
            }
            time++;
        }

        // Traverse grid again to ensure no fresh orange.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
