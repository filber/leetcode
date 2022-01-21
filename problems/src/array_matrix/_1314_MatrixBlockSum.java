package array_matrix;

// https://leetcode.com/problems/matrix-block-sum/

public class _1314_MatrixBlockSum {

//  Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n, K <= 100
//    1 <= mat[i][j] <= 100

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] sumTable = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i > 0 ? sumTable[i - 1][j] : 0;
                int left = j > 0 ? sumTable[i][j - 1] : 0;
                int topLeft = i > 0 && j > 0 ? sumTable[i - 1][j - 1] : 0;
                sumTable[i][j] = top + left - topLeft + mat[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int x1 = i - k - 1;
                int y1 = j - k - 1;
                int x2 = i + k;
                int y2 = j + k;

                int topLeft = 0;
                if (x1 >= 0 &&  y1>= 0) {
                    topLeft = getSum(sumTable, x1, y1);
                }

                int topRight = 0;
                if (x1 >= 0) {
                    topRight = getSum(sumTable, x1, Math.min(n - 1, y2));
                }

                int bottomLeft = 0;
                if (y1 >= 0) {
                    bottomLeft = getSum(sumTable, Math.min(m - 1, x2), y1);
                }

                int bottomRight = getSum(sumTable, Math.min(m - 1, x2), Math.min(n - 1, y2));

                ans[i][j] = bottomRight - bottomLeft - topRight + topLeft;
            }
        }

        return ans;
    }


    private static int getSum(int[][] sumTable, int i, int j) {
        int m = sumTable.length;
        int n = sumTable[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        } else {
            return sumTable[i][j];
        }
    }

    public static void main(String[] args) {
//    Output: [[12,21,16],[27,45,33],[24,39,28]]
        int[][] m1 = matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}, 1);

//    Output: [[45,45,45],[45,45,45],[45,45,45]]
        int[][] m2 = matrixBlockSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}, 2);

        int[][] m3 = matrixBlockSum(new int[][]{
                {67, 64, 78},
                {82, 46, 46},
                {6, 52, 55},
                {55, 99, 45}}, 1);
    }
}