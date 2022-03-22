package string;

//https://leetcode.com/problems/one-edit-distance/

public class _161_OneEditDistance {

    boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return isOneEditDistance(t, s);
        } else if (m - n > 1) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int l = 0, r = 0;
        int mc = 0;
        while (l < m && r < n) {
            if (sChars[l] == tChars[r]) {
                l++;
                r++;
            } else {
                mc++;
                if (mc == 2) {
                    return false;
                }
                l++; // delete S[l]
                if (m == n) {
                    r++; // replace T[r]
                }
            }
        }

        return true;
    }
}
