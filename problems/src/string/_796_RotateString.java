package string;

//https://leetcode.com/problems/rotate-string/

public class _796_RotateString {

    public boolean rotateString(String s, String goal) {
        char[] sChars = s.toCharArray();
        char[] gChars = goal.toCharArray();
        if (sChars.length != gChars.length) {
            return false;
        }
        int n = gChars.length;
        int l = 0, r = 0, len = 0;

        while (r + len < n) {
            if (sChars[l + len] == gChars[r + len]) {
                len++;
            } else {
                r++;
                len = 0;
            }
        }

        if (len == n) {
            return true;
        }

        for (int i = 0; i < n - len; i++) {
            if (gChars[i] != sChars[i + len]) {
                return false;
            }
        }
        return true;
    }
}
