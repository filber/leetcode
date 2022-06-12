package array_matrix;

//https://leetcode.com/problems/rotate-image/

public class _48_RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = n;
        for (int i = 0; i < (n + 1) / 2; i++) {
            rotateRing(matrix, k, i, i);
            k -= 2;
        }
    }

    public void rotateRing(int[][] matrix, int n, int i, int j) {
        if (n <= 1) {
            return;
        }
        int TOP_I = i;
        int RIGHT_J = j + n - 1;
        int BOTTOM_I = i + n - 1;
        int LEFT_J = j;

        for (int k = 0; k < n - 1; k++) {
            int topI = TOP_I;
            int topJ = LEFT_J + k;

            int rightI = TOP_I + k;
            int rightJ = RIGHT_J;

            int bottomI = BOTTOM_I;
            int bottomJ = RIGHT_J - k;

            int leftI = BOTTOM_I - k;
            int leftJ = LEFT_J;

            int tmp = matrix[leftI][leftJ];
            matrix[leftI][leftJ] = matrix[bottomI][bottomJ];
            matrix[bottomI][bottomJ] = matrix[rightI][rightJ];
            matrix[rightI][rightJ] = matrix[topI][topJ];
            matrix[topI][topJ] = tmp;
        }
    }

}
