package dp;

// https://leetcode.com/problems/unique-paths-ii/

// TOPICS:
// [Dynamic Programming], [Matrix]
public class _63_UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0]==1) {
            // can not move
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0) {
                    dp[i][j] = 1; // start position
                }
                else if (obstacleGrid[i][j]==1) {
                    dp[i][j] = 0; // obstacle
                }
                else if (i==0) {
                    // first row
                    if (dp[i][j-1]==0) {
                        dp[i][j] = 0; // can not reach left position
                    } else {
                        dp[i][j] = 1;
                    }
                } else if (j==0) {
                    // first column
                    if (dp[i - 1][j] == 0) {
                        dp[i][j] = 0; // can not reach upper position
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int p1 = uniquePathsWithObstacles(new int[][]{
                {1},
        });
        int p2 = uniquePathsWithObstacles(new int[][]{
                {0},
        });
        int p3 = uniquePathsWithObstacles(new int[][]{
                {0,0},
                {0,1},
        });
        int p4 = uniquePathsWithObstacles(new int[][]{
                {0,1},
                {0,0},
        });
        int p5 = uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });
    }

}
