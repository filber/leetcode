package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
//[Dynamic Programming],[Backtracking],[Depth-First Search]

public class _131_PalindromePartitioning {

    boolean[][] dp;

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        char[] chars = s.toCharArray();
        initDP(chars);

        List<String> list = new ArrayList<>();
        backtracking(chars, list, 0);
        return ans;
    }

    private void backtracking(char[] chars, List<String> list, int i) {
        if (i == chars.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < chars.length; j++) {
            if (dp[i][j]) {
                // set state
                list.add(new String(chars, i, j - i + 1));
                backtracking(chars,list,j+1);
                // reverse state
                list.remove(list.size() - 1);
            }
        }
    }

    private void initDP(char[] chars) {
        int n = chars.length;
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
    }


    public static void main(String[] args) {
        List<List<String>> p1 = new _131_PalindromePartitioning().partition("aab");
        List<List<String>> p2 = new _131_PalindromePartitioning().partition("a");
        List<List<String>> p3 = new _131_PalindromePartitioning().partition("aabb");
    }
}
