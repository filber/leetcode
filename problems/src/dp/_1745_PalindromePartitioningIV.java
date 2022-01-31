package dp;

// https://leetcode.com/problems/palindrome-partitioning-iv/

public class _1745_PalindromePartitioningIV {

    public static boolean checkPartitioning(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        boolean[][] pDP = initDP(chars);

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (pDP[0][i]&&pDP[i+1][j]&&pDP[j+1][n-1]) {
                    return true;
                }
            }
        }
        return false;
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
        // true
        boolean b1 = checkPartitioning("abcbdd");

        // false
        boolean b2 = checkPartitioning("bcbddxy");

        // true
        boolean b3 = checkPartitioning("aabb");

        // false
        boolean b4 = checkPartitioning("abcb");

        // true
        boolean b5 = checkPartitioning("bbab");

        // true
        boolean b6 = checkPartitioning("aaax");

    }
}
