package string;

//https://leetcode.com/problems/backspace-string-compare/

public class _844_BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        int l = sChars.length - 1;
        char[] tChars = t.toCharArray();
        int r = tChars.length - 1;

        while (l >= 0 || r >= 0) {
            l = move(sChars, l);
            r = move(tChars, r);
            if (l == -1 && r == -1) {
                return true;
            } else if (l >= 0 && r >= 0) {
                if (sChars[l] == tChars[r]) {
                    l--;
                    r--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private int move(char[] chars, int i) {
        int skip = 0;
        while (i >= 0) {
            if (chars[i] == '#') {
                skip++;
                i--;
            } else if (skip > 0) {
                skip--;
                i--;
            } else {
                return i;
            }
        }

        return i;
    }
}
