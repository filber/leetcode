package bfs;

//https://leetcode.com/problems/01-matrix/

import java.util.ArrayDeque;
import java.util.Queue;

public class _542_01Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] rst = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 &&
                        (isZero(mat, i - 1, j) ||
                                isZero(mat, i + 1, j) ||
                                isZero(mat, i, j - 1) ||
                                isZero(mat, i, j + 1)
                        )) {
                    rst[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int i = position[0];
            int j = position[1];

            for (int k = 0; k < DIR.length; k++) {
                int nextI = i + DIR[k][0];
                int nextJ = j + DIR[k][1];
                if (notSet(mat, rst, nextI, nextJ)) {
                    rst[nextI][nextJ] = rst[i][j] + 1;
                    queue.add(new int[]{nextI, nextJ});
                }
            }
        }
        return rst;
    }

    private boolean notSet(int[][] mat, int[][] rst, int i, int j) {
        if (i < 0 || i == mat.length || j < 0 || j == mat[0].length) {
            return false;
        }
        return mat[i][j] == 1 && rst[i][j] == 0;
    }

    private boolean isZero(int[][] mat, int i, int j) {
        if (i < 0 || i == mat.length || j < 0 || j == mat[0].length) {
            return false;
        }
        return mat[i][j] == 0;
    }
}
