package dp;

// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
import java.util.Arrays;

public class _1738_FindKthLargestXORCoordinateValue {

    int m;
    int n;
    public int kthLargestValue(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length;
        int[] dp = new int[m * n];
        dp[0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[coordiante(i, 0)] = dp[coordiante(i - 1, 0)] ^ matrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[coordiante(0, j)] = dp[coordiante(0, j - 1)] ^ matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // A^A = 0
                // A^0 = A
                // A^A^A = A
                // DP[i-1][j-1] 3
                // DP[i-1][j]  1
                // DP[i][j-1] 1
                dp[coordiante(i, j)] = dp[coordiante(i - 1, j - 1)]
                        ^ dp[coordiante(i - 1, j)]
                        ^ dp[coordiante(i, j - 1)]
                        ^ matrix[i][j];
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - k];
    }

    public int coordiante(int i, int j) {
        return i * n + j;
    }
}
