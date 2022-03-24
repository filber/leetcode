package string;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

public class _1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int stack = 0;
        // forward
        while (r < n) {
            char ch = chars[r++];
            chars[l++] = ch;
            if (ch == '(') {
                stack++;
            } else if (ch == ')') {
                stack--;
            }
            if (stack < 0) {
                l--;
                stack++;
            }
        }

        stack = 0;
        int end = l - 1;
        r = end;
        l = end;
        // backward
        while (l >= 0) {
            char ch = chars[l--];
            chars[r--] = ch;
            if (ch == ')') {
                stack++;
            } else if (ch == '(') {
                stack--;
            }
            if (stack < 0) {
                r++;
                stack++;
            }
        }

        int start = r + 1;
        return new String(chars, start, end - start + 1);
    }
}
