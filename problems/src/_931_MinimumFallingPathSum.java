public class _931_MinimumFallingPathSum {

//  Constraints:
//  n == matrix.length
//  n == matrix[i].length
//  1 <= n <= 100
//  -100 <= matrix[i][j] <= 100

  public static int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix.length];
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (i == 0) {
          dp[i][j] = matrix[i][j];
        } else {
          if (j==0) {
            dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
          } else if (j == (matrix.length - 1)) {
            dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
          } else {
            dp[i][j] =
                matrix[i][j] + Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
          }
        }
        if (i == (matrix.length - 1)) {
          result = Math.min(dp[i][j], result);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
//    minFallingPathSum(new int[][] {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
//    minFallingPathSum(new int[][] {{-19, 57}, {-40, -5}});
//    minFallingPathSum(new int[][] {{-48}});

    minFallingPathSum(new int[][]
        {{100, -42, -46, -41},
        {31, 97, 10, -10},
        {-58, -51, 82, 89},
        {51, 81, 69, -51}});
  }
}
