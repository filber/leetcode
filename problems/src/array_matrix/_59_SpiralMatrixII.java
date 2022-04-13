package array_matrix;

//https://leetcode.com/problems/spiral-matrix-ii/

public class _59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        fill(m, 1, 0, 0, n);
        return m;
    }

    private void fill(int[][] m, int start, int x, int y, int n) {
        if (n == 0) {
            return;
        } else if (n == 1) {
            m[x][y] = start;
            return;
        }

        for (int i = 0; i < n; i++) {
            m[x][y + i] = start++;
        }
        for (int i = 1; i < n; i++) {
            m[x + i][y + n - 1] = start++;
        }
        for (int i = 1; i < n; i++) {
            m[x + n - 1][y + n - 1 - i] = start++;
        }
        for (int i = 1; i < n - 1; i++) {
            m[x + n - 1 - i][y] = start++;
        }

        fill(m, start, x + 1, y + 1, n - 2);
    }
}
