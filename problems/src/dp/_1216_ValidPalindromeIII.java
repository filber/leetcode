package dp;

//https://leetcode.com/problems/valid-palindrome-iii/

public class _1216_ValidPalindromeIII {

//    Given a string s and an integer k, find out if the given string is a K-Palindrome or not.
//    A string is K-Palindrome if it can be transformed into a palindrome by
//    removing at most k characters from it.

//    Example 1:
//    Input: s = "abcdeca", k = 2
//    Output: true
//    Explanation: Remove 'b' and 'e' characters.

//    Constraints:
//        1 <= s.length <= 1000
//        s has only lowercase English letters.
//        1 <= k <= s.length

    // Remove at most k chars
    public boolean validPalindrome(String s, int k) {
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
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return n - dp[0][n - 1] <= k;
    }
}
