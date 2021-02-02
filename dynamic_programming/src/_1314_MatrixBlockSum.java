public class _1314_MatrixBlockSum {

//  Constraints:
//    m == mat.length
//    n == mat[i].length
//    1 <= m, n, K <= 100
//    1 <= mat[i][j] <= 100

  public static int[][] matrixBlockSum(int[][] mat, int K) {
    // cumulative sum matrix
    int row = mat.length;
    int col = mat[0].length;
    int[][] dp = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          if (j == 0) {
            dp[i][j] = mat[i][j];
          } else {
            dp[i][j] = dp[i][j - 1] + mat[i][j];
          }
        } else {
          if (j == 0) {
            dp[i][j] = dp[i - 1][j] + mat[i][j];
          } else {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + mat[i][j];
          }
        }
      }
    }

    int[][] blockSum = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int upperLeftX = Math.max(i - K, 0);
        int upperLeftY = Math.max(j - K, 0);
        int bottomRightX = Math.min(i + K, row - 1);
        int bottomRightY = Math.min(j + K, col - 1);
        int d;
        if (upperLeftX == 0 && upperLeftY == 0) {
          d = dp[bottomRightX][bottomRightY];
        } else if (upperLeftX == 0) {
          int a = 0;
          int b = 0;
          int c = dp[bottomRightX][upperLeftY - 1] - a;
          d = dp[bottomRightX][bottomRightY] - a - b - c;
        } else if (upperLeftY == 0) {
          int a = 0;
          int b = dp[upperLeftX - 1][bottomRightY] - a;
          int c = 0;
          d = dp[bottomRightX][bottomRightY] - a - b - c;
        } else {
          int a = dp[upperLeftX - 1][upperLeftY - 1];
          int b = dp[upperLeftX - 1][bottomRightY] - a;
          int c = dp[bottomRightX][upperLeftY - 1] - a;
          d = dp[bottomRightX][bottomRightY] - a - b - c;
        }
        blockSum[i][j] = d;
      }
    }

    return blockSum;
  }

  public static void main(String[] args) {
//    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//    Output: [[12,21,16],[27,45,33],[24,39,28]]
    matrixBlockSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);

//    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
//    Output: [[45,45,45],[45,45,45],[45,45,45]]
    matrixBlockSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2);

    matrixBlockSum(new int[][] {{67, 64, 78}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}}, 3);
  }
}
