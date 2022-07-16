package dfs;

//https://leetcode.com/problems/out-of-boundary-paths/

import java.util.Arrays;

public class _576_OutOfBoundaryPaths {
    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int modulo = (int) 1e9 + 7;
    int m;
    int n;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[maxMove + 1][m][n];
        for (int[][] mem : memo) {
            for (int[] c : mem) {
                Arrays.fill(c, -1);
            }
        }
        this.m = m;
        this.n = n;

        return dfs(memo, maxMove, startRow, startColumn);
    }

    private int dfs(int[][][] memo, int move, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        } else if (move == 0) {
            return 0;
        } else if (memo[move][i][j] > -1) {
            return memo[move][i][j];
        }
        int paths = 0;
        for (int d = 0; d < dir.length; d++) {
            int nextI = i + dir[d][0];
            int nextJ = j + dir[d][1];
            paths = (paths + dfs(memo, move - 1, nextI, nextJ)) % modulo;
        }
        memo[move][i][j] = paths;
        return paths;
    }

    public int findPathsDP(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < dir.length; d++) {
                        int nextI = i + dir[d][0];
                        int nextJ = j + dir[d][1];
                        if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n) {
                            dp[k][i][j] += 1;
                        } else {
                            dp[k][i][j] = (dp[k][i][j] + dp[k - 1][nextI][nextJ]) % modulo;
                        }
                    }
                }
            }
        }
        return dp[maxMove][startRow][startColumn];
    }

}
