package array_matrix;

//https://leetcode.com/problems/flipping-an-image/

public class _832_FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 1 ^ image[i][n - 1 - j];
            }
        }
        return res;
    }
}
