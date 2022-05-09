package dp;

//https://leetcode.com/problems/regular-expression-matching/\


public class _10_RegularExpressionMatching {

    char[] sChars;
    char[] pChars;

    public boolean isMatch(String s, String p) {
        sChars = s.toCharArray();
        pChars = convert(p);
        int m = sChars.length;
        int n = pChars.length;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && (pChars[j - 1] == '#' || Character.isUpperCase(pChars[j - 1]));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pCh = pChars[j - 1];
                if (pCh == '.' || Character.isLowerCase(pCh)) {
                    dp[i][j] = dp[i - 1][j - 1] && (pCh == '.' || sChars[i - 1] == pCh);
                } else {
                    if (dp[i][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        int k = i;
                        pCh = pCh == '#' ? pCh : Character.toLowerCase(pCh);
                        while (k > 0 && (pCh == '#' || sChars[k - 1] == pCh) && !dp[k][j - 1]) {
                            k--;
                        }
                        dp[i][j] = dp[k][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private char[] convert(String pattern) {
        char[] pChars = pattern.toCharArray();
        int startCnt = 0;
        for (char ch : pChars) {
            if (ch == '*') {
                startCnt++;
            }
        }
        int n = pChars.length - startCnt;
        char[] rst = new char[n];
        int i = n - 1;
        for (int j = pChars.length - 1; j >= 0; j--) {
            char pch = pChars[j];
            if (pch == '*') {
                pch = pChars[--j];
                rst[i--] = pch == '.' ? '#' : Character.toUpperCase(pch);
            } else {
                rst[i--] = pch;
            }
        }

        return rst;
    }
}
