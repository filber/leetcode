package array_matrix;

//https://leetcode.com/problems/spiral-matrix-ii/

public class _59_SpiralMatrixII {

    int[][] m;

    public int[][] generateMatrix(int n) {
        m = new int[n][n];
        fill(1, 0, 0, n);
        return m;
    }

    private void fill(int i, int x, int y, int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            m[x][y] = i;
            return;
        }
        for (int j = 0; j < n; j++) {
            m[x][y + j] = i++;
        }
        for (int j = 0; j < n - 1; j++) {
            m[x + 1 + j][y + n - 1] = i++;
        }
        for (int j = 0; j < n - 1; j++) {
            m[x + n - 1][y + n - 2 - j] = i++;
        }
        for (int j = 0; j < n - 2; j++) {
            m[x + n - 2 - j][y] = i++;
        }
        fill(i, x + 1, y + 1, n - 2);
    }
}
