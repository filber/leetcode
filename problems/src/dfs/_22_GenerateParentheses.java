package dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/

public class _22_GenerateParentheses {

    int n;
    char[] chars;
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = 2 * n;
        chars = new char[this.n];
        backtracking(0, 0);
        return ans;
    }

    private void backtracking(int i, int stack) {
        if (i == n) {
            ans.add(new String(chars));
            return;
        }
        if (stack == 0) {
            chars[i] = '(';
            backtracking(i + 1, stack + 1);
        } else if (n - i == stack) {
            chars[i] = ')';
            backtracking(i + 1, stack - 1);
        } else {
            chars[i] = '(';
            backtracking(i + 1, stack + 1);

            chars[i] = ')';
            backtracking(i + 1, stack - 1);
        }
    }
}
