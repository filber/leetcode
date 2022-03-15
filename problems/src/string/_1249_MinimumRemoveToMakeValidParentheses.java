package string;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

public class _1249_MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();

        int fLen = 0;
        int cnt = 0;
        // Forward fill
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }
            chars[fLen++] = ch;
            if (cnt < 0) {
                fLen--;
                cnt = 0;
            }
        }

        cnt = 0;
        int bLen = fLen - 1;
        for (int i = fLen - 1; i >= 0; i--) {
            char ch = chars[i];
            if (ch == ')') {
                cnt++;
            } else if (ch == '(') {
                cnt--;
            }
            chars[bLen--] = ch;
            if (cnt < 0) {
                bLen++;
                cnt = 0;
            }
        }

        String res = new String(chars, bLen + 1, fLen - bLen - 1);
        return res;
    }
}
