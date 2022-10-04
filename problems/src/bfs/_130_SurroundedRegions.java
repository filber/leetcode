package bfs;

//https://leetcode.com/problems/surrounded-regions/

import java.util.ArrayDeque;
import java.util.Queue;

public class _130_SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'Y';
                queue.add(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'Y';
                queue.add(new int[]{i, n - 1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'Y';
                queue.add(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = 'Y';
                queue.add(new int[]{m - 1, j});
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int[] d : dir) {
                int nextI = i + d[0];
                int nextJ = j + d[1];
                if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n || board[nextI][nextJ] != 'O') {
                    continue;
                }
                board[nextI][nextJ] = 'Y';
                queue.add(new int[]{nextI, nextJ});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
