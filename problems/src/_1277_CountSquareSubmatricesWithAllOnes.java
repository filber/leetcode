public class _1277_CountSquareSubmatricesWithAllOnes {

    public static int countSquares(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] != 0) {
                    int min = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]);
                    matrix[i][j] += min;
                }
                ans += matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        // Output: 15
        countSquares(matrix1);

        int[][] matrix2 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        // Output: 7
        countSquares(matrix2);
    }
}
