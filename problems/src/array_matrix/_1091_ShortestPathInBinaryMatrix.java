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

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;

        int distance = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                if (x == n - 1 && y == n - 1) {
                    return distance;
                }
                for (int[] dir : DIR) {
                    int nextX = dir[0] + x;
                    int nextY = dir[1] + y;
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                        grid[nextX][nextY] = 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            distance++;
        }

        return -1;
    }
}
