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
        if (digits.isEmpty()) {
            return List.of();
        }
        char[] chars = digits.toCharArray();
        int n = chars.length;
        char[] str = new char[n];
        dfs(chars, str, 0);

        return ans;
    }

    private void dfs(char[] chars, char[] str, int i) {
        if (i == chars.length) {
            ans.add(new String(str));
            return;
        }
        char digit = chars[i];
        char[] letters = LETTERS[digit - '2'];
        for (char letter : letters) {
            str[i] = letter;
            dfs(chars, str, i + 1);
        }
    }
}
