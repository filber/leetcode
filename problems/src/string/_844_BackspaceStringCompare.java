package string;

//https://leetcode.com/problems/backspace-string-compare/

public class _844_BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] sStack = new char[sChars.length];
        int sTop = -1;
        for (char ch : sChars) {
            if (ch == '#') {
                if (sTop >= 0) {
                    sTop--;
                }
            } else {
                sStack[++sTop] = ch;
            }
        }

        char[] tChars = t.toCharArray();
        char[] tStack = new char[tChars.length];
        int tTop = -1;
        for (char ch : tChars) {
            if (ch == '#') {
                if (tTop >= 0) {
                    tTop--;
                }
            } else {
                tStack[++tTop] = ch;
            }
        }

        if (sTop != tTop) {
            return false;
        }
        for (int i = 0; i <= sTop; i++) {
            if (sStack[i] != tStack[i]) {
                return false;
            }
        }
        return true;
    }

}
