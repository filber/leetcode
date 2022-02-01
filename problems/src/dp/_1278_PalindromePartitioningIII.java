package dp;

// https://leetcode.com/problems/palindrome-partitioning-iii/
public class _1278_PalindromePartitioningIII {
    public static int palindromePartition(String s, int K) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] steps = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n && i + len - 1 < n; i++) {
                int j = i + len - 1;
                // STF
                if (chars[i] == chars[j]) {
                    steps[i][j] = steps[i + 1][j - 1];
                } else {
                    steps[i][j] = steps[i + 1][j - 1] + 1;
                }
            }
        }

        // dp[i][k]: partition substring[0,i] into k parts
        int[][] dp = new int[n][K];
        for (int i = 0; i < n; i++) {
            // k = 1
            dp[i][0] = steps[0][i];
        }

        // dp[0][k] always 0, substring[0,0] is a palindrome

        for (int i = 1; i < n; i++) {
            for (int k = 1; k < K; k++) {
                // init
                dp[i][k] = Integer.MAX_VALUE;
                for (int j = i; j >= k; j--) {
                    // STF
                    // dp[j-1][k-1], substring[0,j-1] into k-1 parts
                    // steps[j][i], the new part of substring[j,i]
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - 1] + steps[j][i]);
                }
            }
        }
        return dp[n - 1][K - 1];
    }

    public static void main(String[] args) {
        // 1
        int m1 = palindromePartition("abc", 2);
        // 0
        int m2 = palindromePartition("aabbc", 3);
        // 0
        int m3 = palindromePartition("leetcode", 8);
    }
}
