package dp;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class _931_MinimumFallingPathSum {

//  Constraints:
//  n == matrix.length
//  n == matrix[i].length
//  1 <= n <= 100
//  -100 <= matrix[i][j] <= 100

  public static int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    if (n==1) {
      return matrix[0][0];
    }

    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j==0) {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
        } else if (j==n-1) {
          dp[i][j] = Math.min(dp[i - 1][j-1], dp[i - 1][j]) + matrix[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
        }

        if (i==n-1) {
          min = Math.min(min, dp[i][j]);
        }
      }
    }

    return min;
  }

  public static void main(String[] args) {
    // 13
    int m1 = minFallingPathSum(new int[][] {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
    });

    // -59
    int m2 = minFallingPathSum(new int[][] {
            {-19, 57},
            {-40, -5}
    });

    // -48
    int m3 = minFallingPathSum(new int[][] {{-48}});

    // -36
    int m4 = minFallingPathSum(new int[][]{
            {100, -42,  -46,  -41},
            {31,  97,   10,   -10},
            {-58, -51,  82,   89},
            {51,  81,   69,   -51}
    });
  }
}
