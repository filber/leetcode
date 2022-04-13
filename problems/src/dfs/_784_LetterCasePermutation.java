package dfs;

//https://leetcode.com/problems/letter-case-permutation/

import java.util.ArrayList;
import java.util.List;

public class _784_LetterCasePermutation {

    char[] chars;
    int n;
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        chars = s.toCharArray();
        n = chars.length;
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            ans.add(new String(chars));
            return;
        }
        char ch = chars[i];
        if ('0' <= ch && ch <= '9') {
            // no need to change digits
            backtracking(i + 1);
        } else {
            // not change
            backtracking(i + 1);

            // change
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else {
                chars[i] = Character.toUpperCase(ch);
            }
            backtracking(i + 1);
        }
    }
}
