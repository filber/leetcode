package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/

public class _131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        char[] S = s.toCharArray();
        int n = S.length;

        // dp[i][j] whether s[i..j] is palindrome
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n && (i + len - 1) < n; i++) {
                int j = i + len - 1;
                dp[i][j] = S[i] == S[j] && dp[i + 1][j - 1];
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> L = new ArrayList<>();
        backtracking(S, dp, result, L, 0);
        return result;
    }

    // Fill all possible palindrome substrings of S[i..n-1]
    private void backtracking(char[] S, boolean[][] dp, List<List<String>> result, List<String> L, int i) {
        if (i == S.length) {
            result.add(new ArrayList<>(L));
            return;
        }
        for (int j = i; j < S.length; j++) {
            if (dp[i][j]) {
                L.add(new String(S, i, j - i + 1));
                backtracking(S, dp, result, L, j + 1);
                L.remove(L.size() - 1);
            }
        }
    }
}
