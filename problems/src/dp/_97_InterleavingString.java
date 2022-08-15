package dp;

//https://leetcode.com/problems/interleaving-string/

public class _97_InterleavingString {

    public boolean isInterleave(String p, String q, String s) {
        char[] pChars = p.toCharArray();
        int m = pChars.length;
        char[] qChars = q.toCharArray();
        int n = qChars.length;
        char[] sChars = s.toCharArray();
        if (m + n != sChars.length) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Initialize DP
        dp[0][0] = true;
        for (int i = 1; i <= m && pChars[i - 1] == sChars[i - 1]; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= n && qChars[j - 1] == sChars[j - 1]; j++) {
            dp[0][j] = true;
        }

        // Populate DP
        for (int i = 1; i <= m; i++) {
            char pCh = pChars[i - 1];
            for (int j = 1; j <= n; j++) {
                char qCh = qChars[j - 1];
                char sCh = sChars[i + j - 1];
                if (pCh == sCh && dp[i - 1][j] ||
                        qCh == sCh && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        // Final Result
        return dp[m][n];
    }
}
