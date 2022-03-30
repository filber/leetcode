package string;

//https://leetcode.com/problems/backspace-string-compare/

public class _844_BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int l = sChars.length - 1;
        int r = tChars.length - 1;

        while (l >= 0 && r >= 0) {
            // move l until found non-skip chars
            l = move(l, sChars);

            // move r until found non-skip chars
            r = move(r, tChars);

            if (l >= 0 && r >= 0) {
                if (sChars[l] == tChars[r]) {
                    l--;
                    r--;
                } else {
                    return false;
                }
            } else if (l < 0 && r < 0) {
                return true;
            } else {
                return false;
            }
        }
        l = move(l, sChars);
        r = move(r, tChars);
        return l == r;
    }

    private int move(int cursor, char[] chars) {
        int skip = 0;
        while (cursor >= 0) {
            if (chars[cursor] == '#') {
                skip++;
                cursor--;
            } else if (skip > 0) {
                skip--;
                cursor--;
            } else {
                break;
            }
        }
        return cursor;
    }
}
