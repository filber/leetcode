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
        backtracking(i + 1);
        char ch = chars[i];
        if (Character.isAlphabetic(ch)) {
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else {
                chars[i] = Character.toUpperCase(ch);
            }
            backtracking(i + 1);
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else {
                chars[i] = Character.toUpperCase(ch);
            }
        }
    }
}
