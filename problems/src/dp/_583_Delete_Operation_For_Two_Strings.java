package dp;

public class _583_Delete_Operation_For_Two_Strings {

    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        int m = chars1.length;
        char[] chars2 = word2.toCharArray();
        int n = chars2.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int bothDelete = dp[i - 1][j - 1] + 2;
                    int deleteLeft = dp[i - 1][j] + 1;
                    int deleteRight = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(bothDelete, Math.min(deleteLeft, deleteRight));
                }
            }
        }

        return dp[m][n];
    }
}
