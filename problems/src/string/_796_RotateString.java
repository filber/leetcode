package string;

//https://leetcode.com/problems/rotate-string/

public class _796_RotateString {

    public boolean rotateString(String s, String goal) {
        char[] sChars = s.toCharArray();
        char[] gChars = goal.toCharArray();
        if (sChars.length != gChars.length) {
            return false;
        }
        for (int k = 0; k < sChars.length; k++) {
            if (rotate(sChars, gChars, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean rotate(char[] sChars, char[] gChars, int k) {
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != gChars[(i + k) % gChars.length]) {
                return false;
            }
        }
        return true;
    }
}
