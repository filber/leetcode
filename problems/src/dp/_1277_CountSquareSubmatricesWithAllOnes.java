package dp;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class _1277_CountSquareSubmatricesWithAllOnes {

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        // dp[i][j] the max length square with (i,j) at bottom right corner
        int[][] dp = new int[m][n];

        // 1. init first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }

        // 2. init first column
        // start from 1!!! (matrix[0][0] is already added in the first row)
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        // 3. traverse dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==1) {
                    int maxLen = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    dp[i][j] = maxLen;
                    // for every len [1,maxLen], has a new square
                    ans += maxLen;
                }
//                else {
//                    //dp[i][j] default ==0
//                    dp[i][j] = 0;
//                }
            }
        }
        return ans;
    }

    public static int countSquaresPrefixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m][n];
        prefixSum[0][0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    prefixSum[0][0] = matrix[0][0];
                } else if (i == 0) {
                    prefixSum[0][j] = prefixSum[0][j - 1] + matrix[0][j];
                } else if (j == 0) {
                    prefixSum[i][0] = prefixSum[i - 1][0] + matrix[i][0];
                } else {
                    prefixSum[i][j] = prefixSum[i - 1][j] - prefixSum[i - 1][j - 1]
                            + prefixSum[i][j - 1] + matrix[i][j];
                }
            }
        }

        int side = Math.min(m, n);
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= side && i + 1 >= k && j + 1 >= k; k++) {
                    int expectedSum = k * k * 1;
                    int top = i - k >= 0 ? prefixSum[i - k][j] : 0;
                    int left = j - k >= 0 ? prefixSum[i][j - k] : 0;
                    int topLeft = i - k >= 0 && j - k >= 0 ? prefixSum[i - k][j - k] : 0;
                    int sum = prefixSum[i][j] - top - left + topLeft;
                    if (sum == expectedSum) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // 15 [side1:10, side2:4, side3:1]
        int c1 = countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        });
        // 7 [side1:6, side2:1]
        int c2 = countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        });
    }
}
