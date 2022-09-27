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
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        grid[0][0] = 1;
        int path = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                if (x == n - 1 && y == n - 1) {
                    return path;
                }
                for (int k = 0; k < DIR.length; k++) {
                    int nextX = x + DIR[k][0];
                    int nextY = y + DIR[k][1];
                    if (nextX < 0 || nextX == n || nextY < 0 || nextY == n || grid[nextX][nextY] == 1) {
                        continue;
                    }
                    grid[nextX][nextY] = 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            path++;
        }

        return -1;
    }
}
