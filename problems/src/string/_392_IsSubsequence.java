package string;

//https://leetcode.com/problems/is-subsequence/

public class _392_IsSubsequence {

    public boolean isSubsequence(String pat, String txt) {
        int pLen = pat.length();
        int tLen = txt.length();
        if (pLen > tLen) {
            return false;
        }
        int l = 0, r = 0;
        char[] pChars = pat.toCharArray();
        char[] tChars = txt.toCharArray();
        while (l < pLen && r < tLen) {
            if (pChars[l] == tChars[r]) {
                l++;
            }
            r++;
        }

        if (l == pLen) {
            return true;
        } else {
            return false;
        }
    }
}
