package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
//[Dynamic Programming],[Backtracking],[Depth-First Search]

public class _131_PalindromePartitioning {

    private boolean[][] dp;
    private List<List<String>> result = new ArrayList<>();
    private int n;
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        n = s.length();
        constructDP();
        dfs(0,new LinkedList<>());
        return result;
    }

    private void constructDP() {
        dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len - 1 + i;
                if (j>=n) {
                    break;
                }
                if (len == 1) {
                    dp[i][i] = true;
                } else if (len == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
            }
        }
    }

    private void dfs(int start,List<String> list) {
        if (start == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs(i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> p1 = new _131_PalindromePartitioning().partition("aab");
        List<List<String>> p2 = new _131_PalindromePartitioning().partition("a");
        List<List<String>> p3 = new _131_PalindromePartitioning().partition("aabb");
    }
}
