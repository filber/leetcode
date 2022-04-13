package dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class _22_GenerateParentheses {

    int len;
    char[] chars;
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.len = 2 * n;
        chars = new char[len];

        backtracking(0, 0);
        return ans;
    }

    private void backtracking(int i, int stack) {
        if (i == len) {
            ans.add(new String(chars));
            return;
        }
        if (stack == 0) {
            // can only append '('
            chars[i] = '(';
            backtracking(i + 1, stack + 1);
        } else if (len - i - stack == 0) {
            // can only append ')'
            chars[i] = ')';
            backtracking(i + 1, stack - 1);
        } else {
            // try '('
            chars[i] = '(';
            backtracking(i + 1, stack + 1);

            // try ')'
            chars[i] = ')';
            backtracking(i + 1, stack - 1);
        }
    }
}
