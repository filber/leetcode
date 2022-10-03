package string;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

public class _1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int r = remove(chars, 0, 1, '(', ')');
        int l = remove(chars, r - 1, -1, ')', '(');
        return new String(chars, l + 1, r - l - 1);
    }

    int remove(char[] chars, int start, int dir, char keepCh, char delCh) {
        int l = start, r = start;
        int stack = 0;
        while (l < chars.length && l >= 0) {
            if (chars[l] == keepCh) {
                stack++;
                chars[r] = chars[l];
                r += dir;
                l += dir;
            } else if (chars[l] == delCh) {
                stack--;
                if (stack >= 0) {
                    chars[r] = chars[l];
                    l += dir;
                    r += dir;
                } else {
                    stack = 0;
                    l += dir;
                }
            } else {
                chars[r] = chars[l];
                r += dir;
                l += dir;
            }
        }
        return r;
    }
}
