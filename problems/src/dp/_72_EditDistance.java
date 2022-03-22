package dp;

//https://leetcode.com/problems/edit-distance/

public class _72_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 0. Guard condition
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        // 1. Init DP
        // dp[i][j] operations needed for converting word1.substring(0,i) into word2.substring(0,j)
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert
        }

        // 2. Fill DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // remove CHi
                    int removeI = dp[i - 1][j];
                    // change CHi into CHj
                    int replaceI = dp[i - 1][j - 1];
                    // insert CHj
                    int insertJ = dp[i][j - 1];

                    dp[i][j] = Math.min(removeI, Math.min(replaceI, insertJ)) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
