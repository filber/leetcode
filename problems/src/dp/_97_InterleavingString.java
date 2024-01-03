package dp;

//https://leetcode.com/problems/interleaving-string/

public class _97_InterleavingString {

    public boolean isInterleave(String p, String q, String s) {
        int m = p.length();
        int n = q.length();
        if (s.length() != m + n) {
            return false;
        }
        char[] P = p.toCharArray();
        char[] Q = q.toCharArray();
        char[] S = s.toCharArray();

        // whether interleaving p[0..i] and q[0..j] could formulate s[0..i+j]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 1. Initialize
        // 1.1. Both Empty
        dp[0][0] = true;
        // 1.2. Ignore q
        for (int i = 1; i <= m; i++) {
            if (P[i - 1] == S[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        // 1.3. Ignore p
        for (int j = 1; j <= n; j++) {
            if (Q[j - 1] == S[j - 1]) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        // 2. Fill DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((P[i - 1] == S[i + j - 1] && dp[i - 1][j]) ||
                        (Q[j - 1] == S[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
