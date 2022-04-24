package dfs;

//https://leetcode.com/problems/generalized-abbreviation/

import java.util.ArrayList;
import java.util.List;

public class _320_GeneralizedAbbreviation {

    //Write a function to generate the generalized abbreviations of a word.
    // No two adjacent numbers!

    List<String> ans = new ArrayList<>();
    char[] chars;
    char[] abbrev;
    int len = 0;
    int n;

    public List<String> generateAbbreviations(String word) {
        chars = word.toCharArray();
        n = chars.length;
        abbrev = new char[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int i) {
        if (i == n) {
            ans.add(new String(abbrev, 0, len));
            return;
        }
        abbrev[len++] = chars[i];
        backtracking(i + 1);
        len--;

        if (len > 0 && Character.isDigit(abbrev[len - 1])) {
            abbrev[len - 1] += 1;
            backtracking(i + 1);
        } else {
            abbrev[len++] = '1';
            backtracking(i + 1);
            len--;
        }
    }
}
