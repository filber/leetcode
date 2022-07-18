package dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/

public class _22_GenerateParentheses {

    int n;
    char[] chars;
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        chars = new char[this.n * 2];
        backtracking(0, 0, 0);
        return ans;
    }

    private void backtracking(int i, int leftCnt, int rightCnt) {
        if (i == 2 * n) {
            ans.add(new String(chars));
            return;
        }
        if (leftCnt == rightCnt) {
            chars[i] = '(';
            leftCnt++;
            backtracking(i + 1, leftCnt, rightCnt);
        } else if (leftCnt == n) {
            chars[i] = ')';
            rightCnt++;
            backtracking(i + 1, leftCnt, rightCnt);
        } else {
            chars[i] = '(';
            backtracking(i + 1, leftCnt + 1, rightCnt);
            chars[i] = ')';
            backtracking(i + 1, leftCnt, rightCnt + 1);
        }
    }
}
