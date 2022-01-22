package dp;

// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
import java.util.Arrays;

public class _1738_FindKthLargestXORCoordinateValue {

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = matrix[0][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] ^ matrix[i][j];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] ^ matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] ^ dp[i - 1][j - 1] ^ dp[i][j - 1] ^ matrix[i][j];
                }
                arr[i * n + j] = dp[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[arr.length - k];
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{4}};
        int m1_1 = kthLargestValue(m1, 1); // 4

        int[][] m2 = new int[][]{{5, 2}, {1, 6}};
        int m2_1 = kthLargestValue(m2, 1); // 7
        int m2_2 = kthLargestValue(m2, 2); // 5
        int m2_3 = kthLargestValue(m2, 3); // 4
        int m2_4 = kthLargestValue(m2, 4);

        int[][] m3 = new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}};
        int m3_1 = kthLargestValue(m3, 10);
    }
}
