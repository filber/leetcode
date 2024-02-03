package array_matrix;

// https://leetcode.com/problems/matrix-block-sum/

public class _1314_MatrixBlockSum {

    int[][] dp;
    int m;
    int n;

    public int[][] matrixBlockSum(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;
        // dp[i][j]: sum of all elements within <(0,0) ... (i,j)>
        // append an extra row at top and an extra column at the left, all filled with 0s
        dp = new int[m + 1][n + 1];
        // init
        for (int i = 0; i < m; i++) {
            dp[i + 1][1] = dp[i][1] + mat[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[1][j + 1] = dp[1][j] + mat[0][j];
        }

        // iterate
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = sum(i - k, j - k, i + k + 1, j + k + 1);
            }
        }

        return result;
    }

    private int sum(int p, int q, int i, int j) {
        p = Math.max(0, p);
        q = Math.max(0, q);
        i = Math.min(m, i);
        j = Math.min(n, j);

        int A = dp[p][q];
        int B = dp[p][j];
        int C = dp[i][q];
        int sum = dp[i][j] - B - C + A;
        return sum;
    }
}
