package dp;

//https://leetcode.com/problems/edit-distance/

public class _72_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char lCh = chars1[i - 1];
                char rCh = chars2[j - 1];
                if (lCh == rCh) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int removeI = dp[i - 1][j] + 1;
                    int removeJ = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    int min = Math.min(removeI, Math.min(removeJ, replace));
                    dp[i][j] = min;
                }
            }
        }

        return dp[m][n];
    }
}
