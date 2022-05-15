package dfs;

import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber {

    List<String> ans = new ArrayList<>();
    private final char[][] LETTERS = {
            {'a', 'b', 'c'},//2
            {'d', 'e', 'f'},//3
            {'g', 'h', 'i'},//4
            {'j', 'k', 'l'},//5
            {'m', 'n', 'o'},//6
            {'p', 'q', 'r', 's'},//7
            {'t', 'u', 'v'},//8
            {'w', 'x', 'y', 'z'},//9
    };

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        char[] seq = new char[chars.length];
        if (chars.length == 0) {
            return List.of();
        }
        dfs(chars, seq, 0);
        return ans;
    }

    private void dfs(char[] chars, char[] seq, int i) {
        if (i == seq.length) {
            ans.add(new String(seq));
            return;
        }
        char ch = chars[i];
        for (char letter : LETTERS[ch - '2']) {
            seq[i] = letter;
            dfs(chars, seq, i + 1);
        }
    }
}
