package dp;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class _1312_MinimumInsertionStepsToMakeAStringPalindrome {

    public int minInsertions(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[0][n - 1];
    }
}
