package dp;

//https://leetcode.com/problems/distinct-subsequences/

public class _115_DistinctSubsequences {

    // Bottom to Top DFS
    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        m = sChars.length;
        char[] tChars = t.toCharArray();
        n = tChars.length;
        memo = new Integer[m + 1][n + 1];

        return dfs(sChars, 0, tChars, 0);
    }

    Integer[][] memo;
    int m;
    int n;

    private int dfs(char[] sChars, int i, char[] tChars, int j) {
        // 0. Guard condition
        if (i == m || // reach end of sChars
            j == n || // reach end of tChars (found all chars)
            m - i < n - j  // don't have enough chars in sChars
        ) {
            return j == n ? 1 : 0;
        } else if (memo[i][j] != null) {
            return memo[i][j]; // found in memory
        }

        // don't use sChars[i+1]
        int num = dfs(sChars, i + 1, tChars, j);
        if (sChars[i] == tChars[j]) {
            // could use sChars[i]
            num += dfs(sChars, i + 1, tChars, j + 1);
        }

        memo[i][j] = num;
        return num;
    }


    public int numDistinctDP(String s, String t) {
        char[] sChars = s.toCharArray();
        int m = sChars.length;
        char[] tChars = t.toCharArray();
        int n = tChars.length;
        int[][] dp = new int[m + 1][n + 1];
        // if t is empty, the only way is to delete all chars in s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // if s is empty, we have no ways to convert it into non-empty t
        // dp[0][j] = 0, with j>0.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
