package bfs;

//https://leetcode.com/problems/walls-and-gates/

import java.util.ArrayDeque;
import java.util.Queue;

public class _286_WallsAndGates {

    // -1: a wall or an obstacle
    // 0: a gate
    // INF: empty room

    // Fill the empty room with the distance to its nearest gate
    // If it cannot reach a gate, leave it INF
    public int[][] nearestGate(int[][] M) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = M.length;
        int n = M[0].length;
        int[][] rst = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    rst[i][j] = M[i][j];
                }
            }
        }


        int distance = 1;
        final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] position = queue.poll();
                int x = position[0], y = position[1];
                for (int[] dir : DIR) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX < 0 ||
                            nextX == m ||
                            nextY < 0 ||
                            nextY == n ||
                            M[nextX][nextY] != Integer.MAX_VALUE ||
                            (rst[nextX][nextY] > 0 && rst[nextX][nextY] != Integer.MAX_VALUE)) {
                        continue;
                    }
                    rst[nextX][nextY] = distance;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            distance++;
        }
        return rst;
    }
}
