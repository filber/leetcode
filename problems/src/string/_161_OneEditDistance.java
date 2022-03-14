package string;

public class _161_OneEditDistance {

    boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s);
        } else if (s.length() - t.length() > 1) {
            return false;
        }

        char[] sChars = s.toCharArray();
        int m = sChars.length;
        char[] tChars = t.toCharArray();
        int n = tChars.length;
        boolean chanceUsed = false;
        int l = 0, r = 0;
        while (l < m && r < n) {
            if (sChars[l] == tChars[r]) {
                l++;
                r++;
            } else {
                if (chanceUsed) {
                    return false;
                } else {
                    if (m == n) {
                        r++;
                    }
                    l++;
                    chanceUsed = true;
                }
            }
        }
        return true;
    }
}
