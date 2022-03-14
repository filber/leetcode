package dp;

public class _5_LongestPalindromicSubstring {

    // Two Pointers
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0, len = 0;
        for (int i = 0; i < n; i++) {
            int max1 = findMaxAroundCenter(chars, i, i);
            int max2 = findMaxAroundCenter(chars, i, i + 1);
            int max = Math.max(max1, max2);
            if (max > len) {
                start = i - (max - 1) / 2;
                len = max;
            }
        }

        return s.substring(start, start + len);
    }

    private int findMaxAroundCenter(char[] chars, int i, int j) {
        int n = chars.length;
        while (i >= 0 && j < n && chars[i] == chars[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public String longestPalindromeDP(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int startIdx = 0, maxLen = 1;

        boolean oddFound = true;
        boolean evenFound = false;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = chars[i] == chars[i + 1];
            if (dp[i][i + 1]) {
                startIdx = i;
                maxLen = 2;
                evenFound = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            if (len % 2 == 0) {
                evenFound = false;
            } else {
                oddFound = false;
            }

            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        startIdx = i;
                        maxLen = len;
                        if (len % 2 == 0) {
                            evenFound = true;
                        } else {
                            oddFound = true;
                        }
                    }
                }
            }

            if (!evenFound && !oddFound) {
                break;
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }
}
