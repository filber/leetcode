package dfs;

import java.util.Arrays;

// https://leetcode.com/problems/palindrome-partitioning-ii/

public class _132_PalindromePartitioningII {

    public static int minCut(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        boolean[][] pDP = initDP(chars);

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (pDP[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = i; j >= 1; j--) {
                    if (pDP[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n-1];
    }


    private static boolean[][] initDP(char[] chars) {
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        // len = 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // len = 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = chars[i] == chars[i + 1];
        }
        // len = [3,n]
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n && i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        // 1
        int m1 = minCut("aab");
        // 0
        int m2 = minCut("a");
        // 1
        int m3 = minCut("ab");
        // 1
        int m4 = minCut("aabb");
        // 1
        int m5 = minCut("abbab");

    }
}
