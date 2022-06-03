package array_matrix;

//https://leetcode.com/problems/range-sum-query-2d-immutable/

public class _304_RangeSumQuery2DImmutable {

    public static class NumMatrix {
        int m;
        int n;
        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            prefix = new int[m + 1][n + 1];
            // other
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    prefix[i][j] =
                            prefix[i - 1][j] +
                                    prefix[i][j - 1] -
                                    prefix[i - 1][j - 1] +
                                    matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int A = prefix[row2 + 1][col2 + 1];
            int B = prefix[row1][col2 + 1];
            int C = prefix[row2 + 1][col1];
            int D = prefix[row1][col1];
            int rst = A - B - C + D;
            return rst;
        }
    }
}
