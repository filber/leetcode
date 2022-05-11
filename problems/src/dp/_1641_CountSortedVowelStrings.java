package dp;

// https://leetcode.com/problems/count-sorted-vowel-strings/

import java.util.Arrays;

public class _1641_CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int[][] dp = new int[n][6];
        Arrays.fill(dp[0], 1);
        dp[0][5] = 5;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][5];
            dp[i][5] += dp[i][0];
            for (int j = 1; j <= 4; j++) {
                dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
                dp[i][5] += dp[i][j];
            }
        }

        return dp[n - 1][5];
    }
}
