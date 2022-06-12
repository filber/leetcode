package array_matrix;

//https://leetcode.com/problems/set-matrix-zeroes/

public class _73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        long[] rowMaker = new long[4];
        long[] colMaker = new long[4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    int rIdx = i / 64;
                    int rOffset = i % 64;
                    rowMaker[rIdx] |= 1L << rOffset;

                    int cIdx = j / 64;
                    int cOffset = j % 64;
                    colMaker[cIdx] |= 1L << cOffset;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int rIdx = i / 64;
                int rOffset = i % 64;
                int cIdx = j / 64;
                int cOffset = j % 64;
                if (((rowMaker[rIdx] >> rOffset) & 1L) != 0 ||
                        ((colMaker[cIdx] >> cOffset) & 1L) != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
