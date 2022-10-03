package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/

public class _131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        backtracking(chars, dp, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtracking(char[] chars, boolean[][] dp, List<List<String>> ans, ArrayList<String> list, int i) {
        if (i == chars.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < chars.length; j++) {
            if (dp[i][j]) {
                list.add(new String(chars, i, j - i + 1));
                backtracking(chars, dp, ans, list, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
