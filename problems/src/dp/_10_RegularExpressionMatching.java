package dp;

//https://leetcode.com/problems/regular-expression-matching/\


import java.util.Arrays;

public class _10_RegularExpressionMatching {


    public boolean isMatch(String s, String p) {
        char[] P = convertPattern(p.toCharArray());
        char[] S = s.toCharArray();
        int m = S.length;
        int n = P.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (dp[0][j - 1] && isUpper(P[j - 1])) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pCh = P[j - 1];
                if (isLower(pCh)) {
                    dp[i][j] = dp[i - 1][j - 1] && (pCh == '.' || S[i - 1] == pCh);
                } else {
                    int k = i;
                    while (k > 0 && !dp[k][j - 1] && (S[k - 1] - 32 == pCh || pCh == '#')) {
                        k--;
                    }
                    dp[i][j] = dp[k][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private boolean isUpper(char ch) {
        return !isLower(ch);
    }

    private boolean isLower(char ch) {
        return ch == '.' || (ch >= 'a' && ch <= 'z');
    }

    char[] convertPattern(char[] pattern) {
        char[] ans = new char[pattern.length];
        int idx = ans.length - 1;
        for (int i = pattern.length - 1; i >= 0; i--) {
            char ch = pattern[i];
            if (ch == '*') {
                char preceding = pattern[i - 1];
                if (preceding == '.') {
                    ans[idx--] = '#';
                } else {
                    ans[idx--] = (char) (preceding - 32);
                }
                i--;
            } else {
                ans[idx--] = ch;
            }
        }
        return Arrays.copyOfRange(ans, idx + 1, ans.length);
    }
}
